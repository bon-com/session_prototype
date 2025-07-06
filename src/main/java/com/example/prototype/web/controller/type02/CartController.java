package com.example.prototype.web.controller.type02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.prototype.biz.service.type02.ItemService;
import com.example.prototype.web.dto.type02.Cart;
import com.example.prototype.web.dto.type02.CartAddForm;

@Controller
@RequestMapping("type02/cart")
public class CartController {
	/** 商品サービス */
	@Autowired
	private ItemService itemService;
	/** カート（セッション管理） */
	@Autowired
	private Cart cart;

	@PostMapping("/add")
	public String addItem(CartAddForm form) {
		// 追加対象の商品が実在すれば追加
		var item = itemService.findById(form.getItemId());
		int quantity = form.getQuantity();
		if (item != null && quantity > 0) {
			cart.addItem(item, quantity);
		}

		return "redirect:/type02/items/";
	}
}
