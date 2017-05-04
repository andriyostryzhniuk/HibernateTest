package andrii.dao;

import andrii.data.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserDao extends AbstractDaoRealization<User> {

    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    public List<User> getObjects() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    public User getUserById(Integer id) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.where(cb.equal(root.get("id"), id));

        return getEntityManager().createQuery(criteriaQuery).getSingleResult();
    }

}
