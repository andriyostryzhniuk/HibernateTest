package andrii.spring;

import andrii.data.model.Client;
import andrii.data.model.Menu;
import andrii.service.ClientsService;
import andrii.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class MenuController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menuPage")
    public String printMenuPage(ModelMap modelMap){

//        modelMap.put("dishesTypeList", menuService.getDishesType());
        modelMap.put("menu", menuService.getObjects());
        return "menuPage";
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

//    @PostMapping("/addDish")
//    public String addDish(@ModelAttribute Menu menu) {
//
//        menuService.save(menu);
//
//    }
}
