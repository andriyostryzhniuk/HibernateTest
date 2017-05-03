package andrii.controllers;

import andrii.data.model.Menu;
import andrii.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menuPage")
    public String printMenuPage(ModelMap modelMap){

        modelMap.put("menuList", menuService.getObjects());
        modelMap.put("dishesTypeList", menuService.getDishesTypeList());
        return "menu/menuPage";
    }

    @PostMapping("/addDish")
    public String addDish(Integer dishesTypeId,
                          String name,
                          String price,
                          String mass) {

        Menu menu = new Menu(name, new BigDecimal(price), new Double(mass), menuService.getDishesType(dishesTypeId));
        menuService.save(menu);

        return "redirect:/menuPage";
    }

    @GetMapping("/chooseDish")
    public String chooseDish(ModelMap modelMap, String dishesName, String operation) {

        modelMap.put("dishTo" + operation, menuService.getDish(dishesName));
        return "forward:/menuPage";
    }

    @PostMapping("/updateMenu")
    public String updateMenu (@SessionAttribute Menu menu,
                                String name,
                                String price,
                                String mass,
                                Integer dishesTypeId) {
        menu.setName(name);
        menu.setPrice(new BigDecimal(price));
        menu.setMass(new Double(mass));
        menu.setType(menuService.getDishesType(dishesTypeId));

        menuService.update(menu);
        return "redirect:/menuPage";
    }

    @GetMapping("/deleteDish")
    public String deleteDish (@SessionAttribute Menu menu) {

        menuService.delete(menu);
        return "redirect:/menuPage";
    }

}
