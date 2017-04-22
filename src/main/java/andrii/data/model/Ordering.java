package andrii.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ordering implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
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
    private List<Menu> menuList;

    @OneToMany(mappedBy = "ordering", cascade = CascadeType.ALL)
    private List<OrderingMenu> orderingMenuList;

    public Ordering() {
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

    public List<OrderingMenu> getOrderingMenuList() {
        return orderingMenuList;
    }

    public void setOrderingMenuList(List<OrderingMenu> orderingMenuList) {
        this.orderingMenuList = orderingMenuList;
    }
}
