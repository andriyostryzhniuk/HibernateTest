package andrii.spring;

import andrii.data.model.Client;
import andrii.logic.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public String clientSubmit(@ModelAttribute Client client) {

        clientDao.save(client);
        return "forward:/main";
    }
}
