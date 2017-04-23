package andrii.dao;

import andrii.data.model.Client;
import andrii.data.model.Menu;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class MenuDao extends AbstractDaoRealization<Menu> {

    @Override
    public void save(Menu menu) {
        getSession().save(menu);
    }

    @Override
    public List<Menu> getObjects() {
        return getSession()
                .createQuery("from Menu ")
                .list();
    }

    @Override
    public void update(Menu menu) {
        Query query = getSession().createQuery("update Menu " +
                    "set type = :type, " +
                    "name = :name, " +
                    "price = :price, " +
                    "mass = :mass, " +
                    "ingredients = :ingredients " +
                "where id = :id");
        query.setParameter("type", menu.getType().getId());
        query.setParameter("name", menu.getName());
        query.setParameter("price", menu.getPrice());
        query.setParameter("mass", menu.getMass());
        query.setParameter("ingredients", menu.getIngredients());
        query.setParameter("id", menu.getId());

        int result = query.executeUpdate();
    }

    @Override
    public void delete(Menu menu) {
        Query query = getSession().createQuery("delete Menu " +
                "where id = :id");
        query.setParameter("id", menu.getId());
        int result = query.executeUpdate();
    }

    public List<Menu> getOrderMenu(Client client, LocalDate date){

        Query query = getSession().createQuery("select menu " +
                "from Menu as menu, " +
                    "OrderingMenu as orderingMenu, " +
                    "Ordering as ordering " +
                "where ordering.client.id = :client_id and " +
                    "ordering.date = :date and " +
                    "ordering.id = orderingMenu.ordering.id and " +
                    "orderingMenu.menu.id = menu.id");

        query.setParameter("client_id", client.getId());
        query.setParameter("date", date);

        List<Menu> menuList = query.list();

        return menuList;
    }
}
