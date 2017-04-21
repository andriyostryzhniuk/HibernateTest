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

    @GetMapping("/showOrders")
    public String showOrders(ModelMap modelMap, String clientName, String operation) {

        clientsService.getOrders(clientName, modelMap);
        modelMap.put("clientTo" + operation, clientsService.getClientDao().selectClient(clientName));

        return "forward:/main";
    }

    @GetMapping("/showMenu")
    public String showMenu(@SessionAttribute Client client, String date) {

        LocalDate localDate = LocalDate.parse(date);
        System.out.println("date: " + localDate + " :: client: " + client.getName());

        return "forward:/main";
    }
}
