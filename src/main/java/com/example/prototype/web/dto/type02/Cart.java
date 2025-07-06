package com.example.prototype.web.dto.type02;

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
	
	/** 商品と数量を追加 */
	public void addItem(Item item, int quantity) {
        items.compute(item.getId(), (k, v) -> {
            if (v == null) {
                return new CartItem(item, quantity);
            } else {
                v.setQuantity(v.getQuantity() + quantity);
                return v;
            }
        });
	}
	
}