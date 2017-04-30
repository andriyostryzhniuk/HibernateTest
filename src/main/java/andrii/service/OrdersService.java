package andrii.service;

import andrii.dao.OrdersDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersService extends OrdersDao {

    @Transactional
    public void showOrdersByMenuProperties() {

        getOrdersByMenuProperties().forEach(item -> System.out.println("Orders: " + item.getDate()));

    }

}
