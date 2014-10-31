package com.thoughtworks.iamcoach.pos.vo;

public class PromotionFactory {
    public static final int DISCOUNT = 1;
    public static final int SECOND_HALF_MONEY = 2;
    public static final int BUY_TWO_GET_ONE = 3;

    public static Promotion getPromotionByType(int type) {
        Promotion promotion = null;
        switch (type) {
            case BUY_TWO_GET_ONE:
                promotion = new BuyTwoGetOnePromotion();
                break;
            case SECOND_HALF_MONEY:
                promotion = new SecondHalfMoneyPromotion();
                break;
            case DISCOUNT:
                promotion = new DiscountPromotion();
                break;
        }
        return promotion;
    }
}