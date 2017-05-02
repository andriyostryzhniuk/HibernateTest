package andrii.dao;

import andrii.data.model.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersDao extends AbstractDaoRealization<Users> {

    @Override
    public void save(Users user) {
        getSession().save(user);
    }

    @Override
    public List<Users> getObjects() {
        return null;
    }

    @Override
    public void update(Users user) {

    }

    @Override
    public void delete(Users user) {

    }
}
