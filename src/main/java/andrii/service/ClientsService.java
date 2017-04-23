package andrii.service;

import andrii.data.model.Client;
import andrii.dao.ClientDao;
import andrii.data.model.Ordering;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService extends ClientDao {

    @Transactional
    public void getOrders (String clientName, ModelMap modelMap) {

        Client client = selectClient(clientName);

        if (client != null) {
            List<Ordering> orders = new ArrayList<>();
            for (Ordering order : client.getOrderings()) {
                orders.add(order);
            }
            modelMap.put("orders", orders);
        }
    }

}
