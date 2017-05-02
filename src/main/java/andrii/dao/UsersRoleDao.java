package andrii.dao;

import andrii.data.model.UserRole;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersRoleDao extends AbstractDaoRealization<UserRole> {

    @Override
    public void save(UserRole value) {

    }

    @Override
    public List<UserRole> getObjects() {
        return null;
    }

    @Override
    public void update(UserRole value) {

    }

    @Override
    public void delete(UserRole value) {

    }

    public UserRole getRole(String role){

        return (UserRole) getSession().createQuery("from UserRole " +
                "where role = :role")
                .setParameter("role", role)
                .list().get(0);
    }

}
