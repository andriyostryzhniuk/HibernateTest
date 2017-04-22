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
public class MenuDao extends AbstractDaoRealization {

    @Override
    public void save(Object value) {

    }

    @Override
    public List getObjects() {
        return null;
    }

    @Override
    public void update(Object value) {

    }

    @Override
    public void delete(Object value) {

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
