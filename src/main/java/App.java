import com.thoughtworks.iamcoach.pos.service.*;


public class App {

    public static void main(String[] args){

        ItemService itemServiceImple = new ItemServiceImple();
        Scanner scanner = new Scanner();
        Cart cart = new Cart(scanner, itemServiceImple);
        Printer printer = new Printer(cart);
        printer.printAllInfo();
    }

}
