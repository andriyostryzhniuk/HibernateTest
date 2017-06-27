package andrii.data.model;

import andrii.json.LocalDateDeserializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.ext.JodaDeserializers;

import javax.persistence.*;
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(nullable = false)
    private LocalDate date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column
    private BigDecimal cost;

    @Column
    private  BigDecimal discount;

    @Column
    private BigDecimal paid;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ordering_menu",
            joinColumns = @JoinColumn(name = "ordering_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menuList;

    @JsonIgnore
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

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

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<OrdersMenu> getOrdersMenuList() {
        return ordersMenuList;
    }

    public void setOrdersMenuList(List<OrdersMenu> orderingMenuList) {
        this.ordersMenuList = orderingMenuList;
    }
}
