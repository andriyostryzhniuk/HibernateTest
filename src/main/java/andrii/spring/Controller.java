package andrii.spring;

import andrii.logic.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    ClientDao clientDao;

    @RequestMapping(value = "/main")
    public String printMainPage() {
        System.out.println("Client's name: " + clientDao.getClients().get(0).getName());
        return "mainPage";
    }
}
