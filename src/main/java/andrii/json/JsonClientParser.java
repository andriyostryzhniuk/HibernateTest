package andrii.json;

import andrii.data.model.Client;
import andrii.data.model.Orders;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JsonClientParser extends JSONTest {

    public static Client readObject(File file) {
        Client client = new Client();

        try {
            JsonNode rootNode = getMapper().readTree(file);

            JsonNode idNode = rootNode.path("id");
            client.setId(idNode.asInt());

            JsonNode nameNode = rootNode.path("name");
            client.setName(nameNode.asText());

            JsonNode addressNode = rootNode.path("address");
            client.setAddress(addressNode.asText());

            JsonNode telephoneNode = rootNode.path("telephoneNumber");
            client.setTelephoneNumber(telephoneNode.asText());

            JsonNode contactPersonNode = rootNode.path("contactPerson");
            client.setContactPerson(contactPersonNode.asText());

            List<Orders> ordersList = new LinkedList<>();
            JsonNode ordersListNode = rootNode.path("ordersList");
            Iterator iterator = ordersListNode.getElements();
            while (iterator.hasNext()){

                JsonNode orderNode = (JsonNode) iterator.next();
                Orders orders = getMapper().convertValue(orderNode, Orders.class);

                ordersList.add(orders);
            }
            client.setOrdersList(ordersList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return client;
    }
}
