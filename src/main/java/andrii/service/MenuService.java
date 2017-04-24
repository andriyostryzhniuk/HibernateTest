package andrii.service;

import andrii.dao.MenuDao;
import andrii.data.model.Client;
import andrii.data.model.Menu;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class MenuService extends MenuDao {

    @Transactional
    public List<Menu> getFullOrderMenu(Client client, LocalDate date){

        List<Menu> menuList = getOrderMenu(client, date);
        menuList.forEach(item -> {
            item.getOrdersMenuList().forEach(innerItem -> innerItem.getServings());
        });

        return menuList;
    }

}
