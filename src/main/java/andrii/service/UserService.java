package andrii.service;

import andrii.dao.UserDao;
import andrii.dao.UserRoleDao;
import andrii.data.model.User;
import andrii.data.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserDao {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleDao userRoleDao;

    public void save(String username, String password) {

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User(username, hashedPassword);

        super.save(user);

        userRoleDao.save(
                new UserRole(user, "ADMIN"));
    }

}
