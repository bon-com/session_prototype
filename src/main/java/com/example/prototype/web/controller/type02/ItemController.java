package com.example.prototype.web.controller.type02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.prototype.biz.service.type02.CartService;
import com.example.prototype.biz.service.type02.ItemService;

@Controller
@RequestMapping("type02/items")
public class ItemController {
	
	/** 商品サービス */
	@Autowired
	private ItemService itemService;
	/** カートサービス */
	@Autowired
	private CartService cartService;

	/**
	 * 商品一覧表示
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/")
	public String items(Model model) {
		// 商品一覧
		model.addAttribute("items", itemService.findAll());

		// カートの数量
		model.addAttribute("cartNum", cartService.getTotalInCart());
		
		return "type02/items";
	}
}
