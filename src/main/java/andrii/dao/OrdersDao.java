package andrii.dao;

import andrii.data.model.Ordering;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrdersDao extends AbstractDaoRealization<Ordering> {


    @Override
    public void save(Ordering value) {

    }

    @Override
    public List<Ordering> getObjects() {
        return getSession().createCriteria(Ordering.class).list();
    }

    @Override
    public void update(Ordering value) {

    }

    @Override
    public void delete(Ordering value) {

    }
}
