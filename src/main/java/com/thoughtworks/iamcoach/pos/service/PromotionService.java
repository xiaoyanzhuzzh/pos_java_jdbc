package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.PromotionDao;
import com.thoughtworks.iamcoach.pos.dao.PromotionDaoImpl;
import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public class PromotionService implements PromotionServiceImpl {
    PromotionDaoImpl promotionDao = new PromotionDao();
    @Override
    public Promotion getPromotionById(String id) {
        return promotionDao.getPromotionById(id);
    }

    @Override
    public List<Promotion> getPromotions() {
        return promotionDao.getPromotions();
    }
}
