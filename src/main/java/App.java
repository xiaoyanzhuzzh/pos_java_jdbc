import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.dao.ItemDaoImpl;
import com.thoughtworks.iamcoach.pos.vo.Item;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){

        List<Item> items = new ArrayList<Item>();
        ItemDaoImpl itemDao = new ItemDao();
        System.out.println(itemDao.getItems());
        System.out.println(itemDao.getItemByBarcode("ITEM000001"));
        System.out.println(itemDao.getItemByBarcode("ITEM000001").getPromotionList());
    }

}
