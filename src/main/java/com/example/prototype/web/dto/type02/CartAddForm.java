package com.example.prototype.web.dto.type02;

import lombok.Data;

/**
 * カート追加リクエストフォーム
 */
@Data
public class CartAddForm {
	/** 商品ID */
    private String itemId;
    /** 数量 */
    private int quantity;
}
