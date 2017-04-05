package andrii.spring;

import andrii.logic.ClientDao;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/main")
    public String printMainPage() {
        ClientDao clientDao = new ClientDao();
        System.out.println("Client's name: " + clientDao.getClients().get(0).getName());
        return "mainPage";
    }
}
