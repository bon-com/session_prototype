package com.example.prototype.web.controller.type02;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.prototype.web.dto.type02.Cart;
import com.example.prototype.web.dto.type02.CartItem;

@Controller
@RequestMapping("type02/order")
public class OrderController {
	/** カート（セッション管理） */
	@Autowired
	private Cart cart;
	
	/**
	 * 注文内容確認画面の表示
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String confirm(Model model) {
		// カート情報
		model.addAttribute("cartitems", cart.getItems().values());
		
		// 合計金額
		int totalPrice = cart.getItems().values().stream().mapToInt(CartItem::getTotal).sum();
		model.addAttribute("totalPrice", totalPrice);
		
		return "type02/confirm";
	}
	
	@GetMapping("/complete")
	public String complete(HttpSession session) {
		// カート情報をセッションから削除
		// SpringがセッションスコープBeanは内部で「scopedTarget.XXX」と保持される
	    session.removeAttribute("scopedTarget.cart");
		return "type02/complete";
	}
}
