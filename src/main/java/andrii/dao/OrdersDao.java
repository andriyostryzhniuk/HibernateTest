package andrii.dao;

import andrii.data.model.Orders;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrdersDao extends AbstractDaoRealization<Orders> {


    @Override
    public void save(Orders value) {

    }

    @Override
    public List<Orders> getObjects() {
        return getSession().createCriteria(Orders.class).list();
    }

    @Override
    public void update(Orders value) {

    }

    @Override
    public void delete(Orders value) {

    }
}
