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

        modelMap.put("clientList", clientDao.getClients());
        return "mainPage";
    }

    @PostMapping("/addClient")
    public String addClient(@ModelAttribute Client client) {

        clientDao.save(client);
        return "forward:/main";
    }

    @GetMapping("/chooseClient")
    public String chooseClient(ModelMap modelMap, String clientName) {

        modelMap.put("clientName", clientName);

        Client clientToUpdating = null;
        for (Client client : clientDao.getClients()) {
            if (client.getName().equals(clientName)) {
                clientToUpdating = client;
                break;
            }
        }
        modelMap.put("clientToUpdating", clientToUpdating);

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
        return "forward:/main";
    }
}
