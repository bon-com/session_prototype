package com.example.prototype.web.dto.type03;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
/**
 * カートクラス
 */
@Data
public class Cart {
	/** 商品毎の情報マップ */
	private Map<String, CartItem> items = new LinkedHashMap<>();
	
}