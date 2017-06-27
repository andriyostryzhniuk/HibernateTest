package andrii.dao;

import andrii.data.model.Client;
import andrii.data.model.Orders;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
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
        return getSession().createQuery("from Client group by name")
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

    public Client getClientByName(String clientName) {

        return (Client) getSession().createCriteria(Client.class)
                .add(Restrictions.eq("name", clientName))
                .list()
                .get(0);
    }

    public Client getClientById(Integer clientId) {

        return (Client) getSession().createCriteria(Client.class)
                .add(Restrictions.eq("id", clientId))
                .list()
                .get(0);
    }

    public List<Orders> getAllClientOrders(Client client){

        Query query = getSession().createQuery("select orders " +
                "from Orders as orders, Client as client " +
                "where orders.client.id = client.id and " +
                "client.id = :clientId");

        query.setParameter("clientId", client.getId());

        return query.list();

    }

}
