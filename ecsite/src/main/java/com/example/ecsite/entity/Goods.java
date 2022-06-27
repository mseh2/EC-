package com.example.ecsite.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="price")
	private String price;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	public Goods() {
	}

	public Goods(long id, String goodsName, String price, Timestamp updatedAt) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.price = price;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
