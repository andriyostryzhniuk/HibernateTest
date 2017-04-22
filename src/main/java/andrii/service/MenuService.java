package andrii.service;

import andrii.dao.MenuDao;
import andrii.data.model.Client;
import andrii.data.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> getOrderMenu(Client client, LocalDate date){
        return menuDao.getOrderMenu(client, date);
    }

    @Transactional
    public List<Menu> getFullOrderMenu(Client client, LocalDate date){

        List<Menu> menuList = menuDao.getOrderMenu(client, date);
        menuList.forEach(item -> {
            item.getOrderingMenuList().forEach(innerItem -> innerItem.getServings());
        });

        return menuList;
    }

    public MenuDao getMenuDao() {
        return menuDao;
    }
}
