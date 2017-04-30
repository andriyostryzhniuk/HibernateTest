package andrii.spring;

import andrii.data.model.Client;
import andrii.data.model.Orders;
import andrii.service.ClientsService;
import andrii.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ClientsService clientsService;

    @RequestMapping("/ordersPage")
    public String ordersPage(ModelMap modelMap) {

        ordersService.showOrdersByMenuProperties();

        modelMap.put("orders", ordersService.getObjects());
        modelMap.put("clientsList", clientsService.getObjects());
        return "orders/ordersPage";
    }

    @PostMapping("/addOrder")
    public String addOrder(String date,
                           Integer clientId,
                           String cost,
                           String discount,
                           String paid) {

        Client client = clientsService.getClientById(clientId);
        LocalDate localDate = LocalDate.parse(date);
        Orders orders = new Orders(
                localDate,
                client,
                new BigDecimal(cost),
                new BigDecimal(discount),
                new BigDecimal(paid));

        ordersService.save(orders);

        return "redirect:/ordersPage";

    }

    @GetMapping("/chooseOrder")
    public String chooseOrder(ModelMap modelMap,
                              String date,
                              Integer clientId,
                              String operation) {

        Client client = clientsService.getClientById(clientId);
        LocalDate localDate = LocalDate.parse(date);

        modelMap.put("orderTo" + operation, ordersService.getOrder(localDate, client));
        return "forward:/ordersPage";
    }

    @PostMapping("/updateOrders")
    public String updateOrders (@SessionAttribute Orders orders,
                              String date,
                              Integer clientId,
                              String cost,
                              String discount,
                              String paid) {

        Client client = clientsService.getClientById(clientId);
        LocalDate localDate = LocalDate.parse(date);

        orders.setDate(localDate);
        orders.setClient(client);
        orders.setCost(new BigDecimal(cost));
        orders.setDiscount(new BigDecimal(discount));
        orders.setPaid(new BigDecimal(paid));

        ordersService.update(orders);

        return "redirect:/ordersPage";
    }

    @GetMapping("/deleteOrders")
    public String deleteOrders (@SessionAttribute Orders orders) {

        ordersService.delete(orders);
        return "redirect:/ordersPage";
    }

}
