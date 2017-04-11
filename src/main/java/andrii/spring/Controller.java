package andrii.spring;

import andrii.data.model.Client;
import andrii.dao.ClientDao;
import andrii.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ClientDao clientDao;

    @Autowired
    private ClientsService clientsService;

    @RequestMapping(value = "/main")
    public String printMainPage(ModelMap modelMap) {

       clientsService.doSomething();

        modelMap.put("clientList", clientDao.getObjects());
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
