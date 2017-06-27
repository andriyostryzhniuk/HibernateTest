package andrii.service;

import andrii.dao.OrdersDao;
import andrii.data.model.Client;
import andrii.dao.ClientDao;
import andrii.data.model.Orders;
import andrii.json.JSONTest;
import andrii.json.JsonClientParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService extends ClientDao {

    private static int i = 0;

    @Transactional
    public void getOrders (String clientName, ModelMap modelMap) {

        Client client = getClientByName(clientName);

        if (client != null) {
            List<Orders> orders = new ArrayList<>();
            for (Orders order : client.getOrdersList()) {
                orders.add(order);
            }
            modelMap.put("orders", orders);
        }
    }

    @Transactional
    public void parseJSON() {

        Client client = getObjects().get(1);
        List<Orders> ordersList = getAllClientOrders(client);
        client.setOrdersList(ordersList);

        JSONTest.parseToJSON(client);

        Client clientFromJson = JsonClientParser.readObject(new File("D:\\user.json"));
        System.out.println(clientFromJson.getName());

        JSONTest.parseToJSON(clientFromJson);
    }

}
