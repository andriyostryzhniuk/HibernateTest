package andrii.spring;

import andrii.logic.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ClientDao clientDao;

    @RequestMapping(value = "/main")
    public String printMainPage(ModelMap modelMap) {

        modelMap.put("clientList", clientDao.getClients());
//        System.out.println("Client's name: " + clientDao.getClients().get(0).getName());
        return "mainPage";
    }
}
