package andrii.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Table
@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Double mass;

    @Column
    private String ingredients;

    @ManyToOne
    @JoinColumn(name = "dishesType_id", nullable = false)
    private DishesType type;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<OrdersMenu> ordersMenuList;

    public Menu() {
    }

    public Menu(String name, BigDecimal price, Double mass, DishesType type) {
        this.name = name;
        this.price = price;
        this.mass = mass;
        this.type = type;
    }

    /*    @ManyToMany(mappedBy = "menuList")
    private List<Orders> orderingList;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public DishesType getType() {
        return type;
    }

    public void setType(DishesType type) {
        this.type = type;
    }

    public List<OrdersMenu> getOrdersMenuList() {
        return ordersMenuList;
    }

    public void setOrdersMenuList(List<OrdersMenu> orderingMenuList) {
        this.ordersMenuList = orderingMenuList;
    }

    /*    public List<Orders> getOrderingList() {
        return orderingList;
    }

    public void setOrderingList(List<Orders> orderingList) {
        this.orderingList = orderingList;
    }*/
}
