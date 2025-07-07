package com.example.prototype.web.controller.type03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.prototype.web.dto.common.HogeForm;

/*
 * @SessionAttributesを使用して同一クラス内のセッションを管理する
 * names属性を使用して、1種類のフォームをセッションで管理
 */
@Controller
@RequestMapping(value = "type03")
@SessionAttributes(names = "hoge")
public class Type03Controller {

	private static final Logger logger = LoggerFactory.getLogger(Type03Controller.class);
	
	/** セッションの初期化： HogeForm */
	@ModelAttribute(name = "hoge")
	public HogeForm setUpForm() {
		return new HogeForm();
	}

	@GetMapping(value = "/first")
	public String first() {
		return "type03/first";
	}

	/* 
	 * @ModelAttributeにて初期化したセッションオブジェクトをハンドラの引数で取得⇒セッションに登録される
	 * @ModelAttributeアノテーションも省略できる
	 */
	@PostMapping(value = "/second-post")
	public String secondPost(@ModelAttribute("hoge") HogeForm form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type03/second";
	}
	
	@GetMapping(value = "/second")
	public String second() {
		return "type03/second";
	}

	@PostMapping(value = "/third-post")
	public String thirdPost(@ModelAttribute("hoge") HogeForm form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type03/third";
	}
	
	@GetMapping(value = "/third")
	public String third() {
		return "type03/third";
	}
	
	@PostMapping(value = "/confirm-post")
	public String confirmPost(@ModelAttribute("hoge") HogeForm form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type03/confirm";
	}
	
	@GetMapping(value = "/confirm")
	public String confirm() {
		return "type03/confirm";
	}
	
	@GetMapping(value = "/complete")
	public String complete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "type03/complete";
	}
}
