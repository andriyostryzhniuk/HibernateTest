package andrii.service;

import andrii.data.model.Client;
import andrii.dao.ClientDao;
import andrii.data.model.Orders;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService extends ClientDao {

    @Transactional
    public void getOrders (String clientName, ModelMap modelMap) {

        Client client = getClientByName(clientName);

        if (client != null) {
            List<Orders> orders = new ArrayList<>();
            for (Orders order : client.getOrderings()) {
                orders.add(order);
            }
            modelMap.put("orders", orders);
        }
    }

}
