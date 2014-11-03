import com.thoughtworks.iamcoach.pos.service.Cart;
import com.thoughtworks.iamcoach.pos.service.CategoryService;
import com.thoughtworks.iamcoach.pos.service.CategoryServiceImpl;
import com.thoughtworks.iamcoach.pos.vo.CartItem;
import com.thoughtworks.iamcoach.pos.vo.Category;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Printer {
    public List<CartItem> cartItems = new ArrayList<CartItem>();

    public Printer(Cart cart){
        this.cartItems = cart.getCartItems();
    }

    public void printAllInfo(){
        printShopName();
        printDate();
        printAllCartItems();
        printTotal();
    }

    private void printShopName(){
        System.out.println("        ********Let's Go 购物清单*********");
        System.out.println("----------------------------------------------------------");
    }

    private void printDate(){
        Date dateAndTime = new Date();

        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(dateAndTime);
        String time = String.format("%tr", dateAndTime);

        System.out.println("           "+ date + "   " + time);
    }

    private Category generateCategory(String id){
        CategoryService categoryServiceImple = new CategoryServiceImpl();
        return categoryServiceImple.getCategoryById(id);
    }

    private void printAllCartItems(){
        System.out.println("************************************************");
        for(CartItem aCartItem: cartItems){
            System.out.println("类别："+ generateCategory(aCartItem.getItem().getId()).getName()
                            + "  名称：" + aCartItem.getItem().getName()
                            + "  数量：" + aCartItem.getNumber()
                            + "  单价：" + aCartItem.getItem().getPrice() + "元"
                            + "  单位：" + aCartItem.getItem().getUnit()
                            + "  小计：" + aCartItem.getSubtotal() + "元"
            );
        }
        System.out.println("************************************************");
    }

    private void printTotal(){
        System.out.println("优惠前：" + getTotal() + "元");
        System.out.println("优惠金额：" + (getTotal() - getActutalTotal()) + "元");
        System.out.println("总计：" + getActutalTotal() + "元");
        System.out.println("----------------------------------------------------------");
    }

    private double getActutalTotal(){
        double actutalTotal = 0;
        for(CartItem aCartItem: cartItems){
            actutalTotal += aCartItem.getSubtotal();
        }
        return actutalTotal;
    }

    private double getTotal(){
        double total = 0;
        for(CartItem aCartItem: cartItems){
            double actualSubTotal = aCartItem.getNumber() * aCartItem.getItem().getPrice();
            total += actualSubTotal;
        }
        return total;
    }
}
