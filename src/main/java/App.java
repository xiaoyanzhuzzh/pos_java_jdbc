import com.thoughtWorks.dao.ItemDao;
import com.thoughtWorks.dao.ItemDaoImpl;
import com.thoughtworks.iamcoach.pos.*;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){

//        ArrayList<Item> items = getItems();
//        Scanner scanner = new Scanner();
//        ArrayList<String> inputs = scanner.getInputs();
//
//        Cart cart = new Cart(inputs, items);
//
//        Printer printer = new Printer(cart.getCartItems());
//        printer.printAllInfo();
        List<Item> items = new ArrayList<Item>();
        ItemDaoImpl itemDao = new ItemDao();
        System.out.println(itemDao.getItemById(1));
        System.out.println(itemDao.getItems());
    }

//    private static ArrayList<Item> getItems(){
//        ArrayList<Item> items = new ArrayList<Item>();
//
//        items.add(new Item(null,"ITEM000001", "橙汁", "瓶", 5.00));
//        items.add(new Item(null,"ITEM000002", "可乐", "瓶", 3.00));
//        items.add(new Item(null,"ITEM000003", "苹果", "斤", 4.50));
//        items.add(new Item(null,"ITEM000004", "雪碧", "瓶", 5.00));
//        items.add(new Item(null,"ITEM000005", "方便面", "袋", 2.50));
//
//        return items;
//    }

}
