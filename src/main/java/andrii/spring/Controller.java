package andrii.spring;

import andrii.data.model.Client;
import andrii.logic.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ClientDao clientDao;

    @RequestMapping(value = "/main")
    public String printMainPage(ModelMap modelMap) {

//        clientDao.getClients().get(0).getOrderings().forEach(ordering -> System.out.println(ordering.getCost()));

        modelMap.put("clientList", clientDao.getClients());
        return "mainPage";
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute Client client) {

        clientDao.save(client);
        return "redirect:/main";
    }

    @GetMapping("/chooseClient")
    public String chooseClient(ModelMap modelMap, String clientName, String operation) {

        modelMap.put("clientTo" + operation, clientDao.selectClient(clientName));
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

        clientDao.update(client);
        return "redirect:/main";
    }

    @GetMapping("/deleteClient")
    public String deleteClient (@SessionAttribute Client client) {

        clientDao.delete(client);
        return "redirect:/main";
    }
}
