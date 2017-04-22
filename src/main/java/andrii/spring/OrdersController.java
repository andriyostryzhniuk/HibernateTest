package andrii.spring;

import andrii.data.model.Client;
import andrii.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class OrdersController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/showOrders")
    public String showOrders(ModelMap modelMap, String clientName) {

        clientsService.getOrders(clientName, modelMap);
        modelMap.put("clientToShow_orders", clientsService.getClientDao().selectClient(clientName));

        return "forward:/main";
    }

    @PostMapping("/showMenu")
    public String showMenu(@SessionAttribute Client client, String date, ModelMap modelMap) {

        LocalDate localDate = LocalDate.parse(date);
        modelMap.put("menu", "borsch");


        clientsService.getOrders(client.getName(), modelMap);
        modelMap.put("clientToShow_orders", client);

        return "forward:/main";
    }
}
