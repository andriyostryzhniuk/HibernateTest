package andrii.logic;

import andrii.data.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component
public class ClientDao {

    private SessionFactory sessionFactory;

//    @Autowired
    private Session getSession() {
        return  sessionFactory.getCurrentSession();
    }

    public void save(Client client) {
        getSession().save(client);
    }

    public List<Client> getClients() {
        return getSession().createCriteria(Client.class).list();
    }
}
