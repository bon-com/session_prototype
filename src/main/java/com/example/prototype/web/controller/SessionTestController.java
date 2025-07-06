package com.example.prototype.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.prototype.web.form.HogeForm;

@Controller
@RequestMapping("test")
public class SessionTestController {

	private static final Logger logger = LoggerFactory.getLogger(SessionTestController.class);

	@GetMapping(value = "/")
	public String other() {
		return "test/test_top";
	}
	
	/*
	 * @SessionAttributesで管理しているセッション情報を
	 * 別コントローラーで参照する　⇒　参照失敗する
	 */
	@GetMapping(value = "/test01-1")
	public String test01_1(@ModelAttribute("hogeForm") HogeForm form) {
		logger.debug("★HogeFormのセッション参照不可確認★： {}\n", form);
		return "test/test_01";
	}
	
	/* 
	 * @SessionAttributeを使えば、セッションにある属性をどのコントローラーでも取り出せる
	 * ただし、デフォルトではセッションに無いと例外がスローされる
	 * required=falseを指定すれば、nullを許容できる安全設計にできる
	 */
	@GetMapping(value = "/test01-2")
	public String test01_2(@SessionAttribute(name = "hogeForm", required = false)  HogeForm form) {
		if (form != null) {
			logger.debug("★HogeFormのセッション参照不可確認★： {}\n", form);
		}
		return "test/test_01";
	}
}
