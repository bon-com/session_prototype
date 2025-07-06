package com.example.prototype.web.controller.type02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.prototype.biz.service.type02.ItemService;
import com.example.prototype.web.dto.type02.Cart;
import com.example.prototype.web.dto.type02.CartItem;

@Controller
@RequestMapping("type02/items")
public class ItemController {
	/** 商品サービス */
	@Autowired
	private ItemService itemService;
	/** カート（セッション管理） */
	@Autowired
	private Cart cart;

	/**
	 * 商品一覧表示
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String items(Model model) {
		// 商品一覧
		model.addAttribute("items", itemService.findAll());

		// カートの数量
		int cartNum = cart.getItems().values().stream().mapToInt(CartItem::getQuantity).sum();
		model.addAttribute("cartNum", cartNum);
		
		return "type02/items";
	}
}
