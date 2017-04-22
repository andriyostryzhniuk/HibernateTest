package andrii.data.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class DishesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String type;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Menu> menuList;

    public DishesType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
