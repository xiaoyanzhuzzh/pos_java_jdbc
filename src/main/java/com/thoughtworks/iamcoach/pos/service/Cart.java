package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.*;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> inputs;
    private List<Item> items;

    public Cart(Scanner scanner, ItemService itemServiceImple){
        this.inputs = scanner.getInputs();
        this.items = itemServiceImple.getItems();
    }

    public List<CartItem> getCartItems() {
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        ArrayList<Promotion> promotionList = null;

        double[] numbers = getNumbers();

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != 0){
                cartItems.add(new CartItem(items.get(i), numbers[i]));
            }
        }
        return cartItems;
    }

    private double[] getNumbers() {
        double numbers[] = new double[items.size()];

        for(int i=0; i<items.size(); i++){
            for(int j=0; j<inputs.size(); j++){
                boolean canSplit = inputs.get(j).contains("-");
                if(canSplit){
                    numbers[i] +=  processSplitedBarcode(i, j);
                }else{
                    numbers[i] += processBarcode(i, j);
                }
            }
        }
        return numbers;
    }

    private double processSplitedBarcode(int i, int j){
        double number = 0;

        String[] barcodeAndNumber = inputs.get(j).split("-");
        if(items.get(i).getBarcode().equals(barcodeAndNumber[0])){
            number = Double.parseDouble(barcodeAndNumber[1]);
        }
        return number;
    }

    private double processBarcode(int i, int j){
        if(items.get(i).getBarcode().equals(inputs.get(j))){
            return 1.0;
        }
        return 0.0;
    }
}
