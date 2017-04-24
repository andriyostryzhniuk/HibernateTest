package andrii.spring;

import andrii.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/ordersPage")
    public String ordersPage(ModelMap modelMap) {

        modelMap.put("orders", ordersService.getObjects());
        return "orders/ordersPage";
    }

}
