package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Promotion;

import java.util.List;

public interface PromotionService {
    Promotion getPromotionById(String id);
    List<Promotion> getPromotions();
}
