package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.*;

import java.util.*;

public class Cart {
    private List<String> inputs;
    private ItemService itemServiceImple;
//    private List<Item> items = new ArrayList<Item>();

    public Cart(Scanner scanner, ItemService itemServiceImple){
        this.inputs = scanner.getInputs();
        this.itemServiceImple = itemServiceImple;
//        this.items = itemServiceImple.getItems();
    }

    public List<CartItem> getCartItems() {
        List<CartItem> cartItems = new ArrayList<CartItem>();

        List<Item> items = itemServiceImple.getItems();

        double[] numbers = getNumbers(items);

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != 0){
                items.get(i).setPromotionList(itemServiceImple.getPromotionsByItemId((items.get(i).getId())));
                cartItems.add(new CartItem(items.get(i), numbers[i]));
            }
        }
        System.out.println(cartItems);
        return cartItems;
    }
//        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
//        double[] numbers = getNumbers();
//
//        for(int i = 0; i < numbers.length; i++){
//            if(numbers[i] != 0){
//                cartItems.add(new CartItem(items.get(i), numbers[i]));
//            }
//        }
//        return cartItems;
//    }

    private double[] getNumbers(List<Item> items) {
        double numbers[] = new double[items.size()];

        for(int i=0; i<items.size(); i++){
            for(int j=0; j<inputs.size(); j++){
                boolean canSplit = inputs.get(j).contains("-");
                if(canSplit){
                    numbers[i] +=  splitBarcodeAndGetNumber(i, j, items);
                }else{
                    numbers[i] += getNumber(i, j, items);
                }
            }
        }
        return numbers;
    }

//    private double[] getNumbers() {
//        double numbers[] = new double[items.size()];
//
//        for(int i = 0; i < items.size(); i++){
//            for(int j = 0; j < inputs.size(); j++){
//                boolean canSplit = inputs.get(j).contains("-");
//                if(canSplit){
//                    numbers[i] +=  SplitBarcodeAndGetNumber(i, j);
//                }else{
//                    numbers[i] += getNumber(i, j);
//                }
//            }
//        }
//        return numbers;
//    }

    private double splitBarcodeAndGetNumber(int i, int j, List<Item> items){
        double number = 0;

        String[] barcodeAndNumber = inputs.get(j).split("-");
        if(items.get(i).getBarcode().equals(barcodeAndNumber[0])){
            number = Double.parseDouble(barcodeAndNumber[1]);
        }
        return number;
    }

    private double getNumber(int i, int j, List<Item> items){
        if(items.get(i).getBarcode().equals(inputs.get(j))){
            return 1.0;
        }
        return 0.0;
    }
}
