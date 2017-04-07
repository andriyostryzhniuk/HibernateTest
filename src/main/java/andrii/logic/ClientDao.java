package andrii.logic;

import andrii.data.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Client client) {
        getSession().save(client);
    }

    public List<Client> getClients() {
        return getSession().createCriteria(Client.class).list();
    }

    public void update(Client client) {
        getSession().update(client);
    }

    public void delete(Client client) {
        getSession().delete(client);
    }

    public Client selectClient(String clientName) {
        Client selectedClient = null;
        for (Client client : getClients()) {
            if (client.getName().equals(clientName)) {
                selectedClient = client;
                break;
            }
        }
        return selectedClient;
    }
}
