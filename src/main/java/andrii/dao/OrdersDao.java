package andrii.dao;

import andrii.data.model.Client;
import andrii.data.model.Orders;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class OrdersDao extends AbstractDaoRealization<Orders> {


    @Override
    public void save(Orders orders) {
        getSession().save(orders);
    }

    @Override
    public List<Orders> getObjects() {

        return getSession().createCriteria(Orders.class)
                .addOrder(Order.desc("date"))
                .list();
    }

    @Override
    public void update(Orders orders) {
        getSession().update(orders);
    }

    @Override
    public void delete(Orders orders) {
        getSession().delete(orders);
    }

    public Orders getOrder(LocalDate date, Client client) {

        return (Orders) getSession().createCriteria(Orders.class)
                .add(Restrictions.eq("date", date))
                .add(Restrictions.eq("client", client))
                .list()
                .get(0);
    }
}
