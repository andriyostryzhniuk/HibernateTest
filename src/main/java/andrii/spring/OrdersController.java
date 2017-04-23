package andrii.spring;

import andrii.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrdersController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/showOrders")
    public String showOrders(ModelMap modelMap, String clientName) {

        clientsService.getOrders(clientName, modelMap);
        modelMap.put("clientToShow_orders", clientsService.selectClient(clientName));

        return "forward:/main";
    }

}
