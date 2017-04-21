package andrii.service;

import andrii.data.model.Client;
import andrii.dao.ClientDao;
import andrii.data.model.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void getOrders (String clientName, ModelMap modelMap) {

        Client client = clientDao.selectClient(clientName);

        if (client != null) {
            List<Ordering> orders = new ArrayList<>();
            for (Ordering order : client.getOrderings()) {
                orders.add(order);
            }
            modelMap.put("orders", orders);
        }
    }

    public ClientDao getClientDao() {
        return clientDao;
    }
}
