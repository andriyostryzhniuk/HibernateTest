package andrii.service;

import andrii.data.model.Client;
import andrii.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void doSomething() {
        List<Client> clients = clientDao.getObjects();
        clients.get(0).getOrderings()
                .forEach(ordering -> System.out.println(ordering.getCost()));
    }

}
