package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.PromotionDaoImple;
import com.thoughtworks.iamcoach.pos.dao.PromotionDao;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public class PromotionServiceImple implements PromotionServiceImpl {
    PromotionDao promotionDao = new PromotionDaoImple();
    @Override
    public Promotion getPromotionById(String id) {
        return promotionDao.getPromotionById(id);
    }

    @Override
    public List<Promotion> getPromotions() {
        return promotionDao.getPromotions();
    }
}
