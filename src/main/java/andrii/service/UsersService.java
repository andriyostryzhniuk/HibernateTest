package andrii.service;

import andrii.dao.UsersDao;
import andrii.dao.UsersRoleDao;
import andrii.data.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends UsersDao {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRoleDao usersRoleDao;

    public void save(String username, String password) {

        String hashedPassword = passwordEncoder.encode(password);

        Users user = new Users(
                username,
                hashedPassword,
                usersRoleDao.getRole("ADMIN"),
                new Byte("1"));

        super.save(user);
    }

}
