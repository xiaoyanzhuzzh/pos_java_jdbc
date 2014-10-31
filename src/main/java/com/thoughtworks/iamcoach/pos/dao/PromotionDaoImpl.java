package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public interface PromotionDaoImpl {
    Promotion getPromotionById(String id);
    List<Promotion> getPromotions();
    void insertPromotion(Promotion promotion);
    void deletePromotionById(int id);
    void updatePromtion(Promotion promotion);
}