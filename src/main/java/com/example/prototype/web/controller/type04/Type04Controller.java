package com.example.prototype.web.controller.type04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.prototype.web.dto.common.HogeForm1;
import com.example.prototype.web.dto.common.HogeForm2;
import com.example.prototype.web.dto.common.HogeForm3;

/*
 * @SessionAttributesを使用して同一クラス内のセッションを管理する
 * names属性を使用して、複数のフォームトをセッションで管理
 */
@Controller
@RequestMapping(value = "type04")
@SessionAttributes(names = { "hoge1", "hoge2", "hoge3" })
public class Type04Controller {

	private static final Logger logger = LoggerFactory.getLogger(Type04Controller.class);
	
	/** セッションの初期化： HogeForm1 */
	@ModelAttribute(name = "hoge1")
	public HogeForm1 setUpForm1() {
		return new HogeForm1();
	}
	/** セッションの初期化： HogeForm2 */
	@ModelAttribute(name = "hoge2")
	public HogeForm2 setUpForm2() {
		return new HogeForm2();
	}
	/** セッションの初期化： HogeForm3 */
	@ModelAttribute(name = "hoge3")
	public HogeForm3 setUpForm3() {
		return new HogeForm3();
	}

	@GetMapping(value = "/first")
	public String first() {
		return "type04/first";
	}

	/*
	 * names属性でキーを明確に指定しているため
	 * @ModelAttributeアノテーションでキーを指定しないと
	 * 引数でフォームの値は取得できるが、セッションに登録されない
	 */
	@PostMapping(value = "/second-post")
	public String secondPost(@ModelAttribute("hoge1")HogeForm1 form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type04/second";
	}
	
	@GetMapping(value = "/second")
	public String second() {
		return "type04/second";
	}

	@PostMapping(value = "/third-post")
	public String thirdPost(@ModelAttribute("hoge2") HogeForm2 form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type04/third";
	}
	
	@GetMapping(value = "/third")
	public String third() {
		return "type04/third";
	}
	
	@PostMapping(value = "/confirm-post")
	public String confirmPost(@ModelAttribute("hoge3") HogeForm3 form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type04/confirm";
	}
	
	@GetMapping(value = "/confirm")
	public String confirm() {
		return "type04/confirm";
	}
	
	@GetMapping(value = "/complete")
	public String complete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "type04/complete";
	}
}
