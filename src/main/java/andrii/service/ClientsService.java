package andrii.service;

import andrii.dao.OrdersDao;
import andrii.data.model.Client;
import andrii.dao.ClientDao;
import andrii.data.model.Orders;
import andrii.json.JSONTest;
import andrii.json.JsonClientParser;
import andrii.xml.XmlClientParser;
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

        JSONTest.parseToJSON(getObjects().get(1));

//        Client clientFromJson = JsonClientParser.readObject(new File("D:\\user.json"));
        Client clientFromJson = JSONTest.parseToJava(new File("D:\\user.json"), Client.class);
    }

    public void parseXML() {

        XmlClientParser.writeXml(getObjects().get(1), new File("D:\\user.xml"));

        Client client = XmlClientParser.readXml(new File("D:\\user.xml"));
//        XmlClientParser.writeXml(getObjects().get(1), new File("D:\\user2.xml"));
    }

}
