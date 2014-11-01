import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImpl;
import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.dao.ItemDaoImpl;
import com.thoughtworks.iamcoach.pos.service.ItemService;
import com.thoughtworks.iamcoach.pos.service.ItemServiceImpl;
import com.thoughtworks.iamcoach.pos.vo.Item;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){

        List<Item> items = new ArrayList<Item>();
        ItemServiceImpl itemService = new ItemService();
        System.out.println(itemService.getItems());
        System.out.println(itemService.getItemByBarcode("ITEM000001"));

        CategoryDaoImpl categoryDao = new CategoryDao();
        System.out.println(categoryDao.getCategoryById("1"));
    }

}
