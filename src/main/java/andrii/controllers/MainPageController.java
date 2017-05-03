package andrii.controllers;

import andrii.data.model.Client;
import andrii.service.ClientsService;
import andrii.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@org.springframework.stereotype.Controller
public class MainPageController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private MenuService menuService;

    @RequestMapping({"/", "/main"})
    public String printMainPage(ModelMap modelMap) {

        modelMap.put("clientList", clientsService.getObjects());
        return "main/mainPage";
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute Client client) {

        clientsService.save(client);
        return "redirect:/main";
    }

    @GetMapping("/chooseClient")
    public String chooseClient(ModelMap modelMap, String clientName, String operation) {

        modelMap.put("clientTo" + operation, clientsService.getClientByName(clientName));
        return "forward:/main";
    }

    @PostMapping("/updateClient")
    public String updateClient (@SessionAttribute Client client,
                                String name,
                                String address,
                                String telephoneNumber,
                                String contactPerson) {
        client.setName(name);
        client.setAddress(address);
        client.setTelephoneNumber(telephoneNumber);
        client.setContactPerson(contactPerson);

        clientsService.update(client);
        return "redirect:/main";
    }

    @GetMapping("/deleteClient")
    public String deleteClient (@SessionAttribute Client client) {

        clientsService.delete(client);
        return "redirect:/main";
    }

    @PostMapping("/showOrders")
    public String showOrders(ModelMap modelMap, String clientName) {

        clientsService.getOrders(clientName, modelMap);
        modelMap.put("clientToShow_orders", clientsService.getClientByName(clientName));

        return "forward:/main";
    }

    @PostMapping("/showOrdersMenu")
    public String showOrdersMenu(@SessionAttribute Client client, String date, ModelMap modelMap) {

        LocalDate localDate = LocalDate.parse(date);
        modelMap.put("menu", menuService.getFullOrderMenu(client, localDate));
        modelMap.put("date", date);

        clientsService.getOrders(client.getName(), modelMap);
        modelMap.put("clientToShow_orders", client);

        return "forward:/main";
    }

}
