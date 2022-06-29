package com.example.ecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecsite.model.entity.Goods;

public interface GoodsRepositpry extends JpaRepository<Goods, Long>{

	
}
