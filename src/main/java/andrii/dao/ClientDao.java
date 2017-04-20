package andrii.dao;

import andrii.data.model.Client;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientDao extends AbstractDaoRealization<Client> {

    @Override
    public void save(Client client) {
        getSession().save(client);
    }

    @Override
    public List<Client> getObjects() {
        return getSession()
                .createQuery("from Client ")
                .list();
    }

    @Override
    public void update(Client client) {
        getSession().update(client);
    }

    @Override
    public void delete(Client client) {
        getSession().delete(client);
    }

    public Client selectClient(String clientName) {
        Client selectedClient = null;
        for (Client client : getObjects()) {
            if (client.getName().equals(clientName)) {
                selectedClient = client;
                break;
            }
        }
        return selectedClient;
    }

}
