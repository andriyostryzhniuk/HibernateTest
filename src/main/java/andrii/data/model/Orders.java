package andrii.data.model;

import andrii.json.LocalDateDeserializer;
import andrii.xml.LocalDateAdapter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ordering")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

    @Column
    private BigDecimal cost;

    @Column
    private  BigDecimal discount;

    @Column
    private BigDecimal paid;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ordering_menu",
            joinColumns = @JoinColumn(name = "ordering_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    @JsonIgnore
    private List<Menu> menuList;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrdersMenu> ordersMenuList;

    public Orders() {
    }

    public Orders(LocalDate date, Client client, BigDecimal cost, BigDecimal discount, BigDecimal paid) {
        this.date = date;
        this.client = client;
        this.cost = cost;
        this.discount = discount;
        this.paid = paid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    @XmlTransient
    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    @XmlTransient
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<OrdersMenu> getOrdersMenuList() {
        return ordersMenuList;
    }

    @XmlTransient
    public void setOrdersMenuList(List<OrdersMenu> orderingMenuList) {
        this.ordersMenuList = orderingMenuList;
    }
}
