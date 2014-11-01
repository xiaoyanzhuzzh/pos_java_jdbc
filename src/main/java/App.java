import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImple;
import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.service.Cart;
import com.thoughtworks.iamcoach.pos.service.ItemServiceImple;
import com.thoughtworks.iamcoach.pos.service.ItemService;
import com.thoughtworks.iamcoach.pos.service.Scanner;
import com.thoughtworks.iamcoach.pos.vo.CartItem;
import com.thoughtworks.iamcoach.pos.vo.Item;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){
        ItemService itemServiceImple = new ItemServiceImple();
        Scanner scanner = new Scanner();
        Cart cart = new Cart(scanner, itemServiceImple);
        Printer printer = new Printer(cart);
        printer.printAllInfo();
    }

}
