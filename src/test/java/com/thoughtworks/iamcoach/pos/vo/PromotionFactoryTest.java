package com.thoughtworks.iamcoach.pos.vo;

import org.junit.Test;

import static com.thoughtworks.iamcoach.pos.vo.PromotionFactory.getPromotionByType;
import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionFactoryTest {

    @Test
    public void can_get_promotion_of_discount_promotion(){
        Promotion promotion = getPromotionByType(3);
        assertThat(promotion instanceof DiscountPromotion).isTrue();
    }

    @Test
    public void can_get_promotion_of_second_half_money(){
        Promotion promotion = getPromotionByType(2);
        assertThat(promotion instanceof SecondHalfMoneyPromotion).isTrue();
    }

    @Test
    public void can_get_promotion_of_buy_two_get_one(){
        Promotion promotion = getPromotionByType(1);
        assertThat(promotion instanceof BuyTwoGetOnePromotion).isTrue();
    }
}
