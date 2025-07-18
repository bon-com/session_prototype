package com.example.prototype.web.controller.type02;

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
 * types属性を使用して、複数のフォームをセッションで管理
 */
@Controller
@RequestMapping(value = "type02")
@SessionAttributes(types = { HogeForm1.class, HogeForm2.class, HogeForm3.class })
public class Type02Controller {

	private static final Logger logger = LoggerFactory.getLogger(Type02Controller.class);

	/** セッションの初期化： HogeForm1 */
	@ModelAttribute
	public HogeForm1 setUpForm1() {
		return new HogeForm1();
	}

	/** セッションの初期化： HogeForm2 */
	@ModelAttribute
	public HogeForm2 setUpForm2() {
		return new HogeForm2();
	}

	/** セッションの初期化： HogeForm3 */
	@ModelAttribute
	public HogeForm3 setUpForm3() {
		return new HogeForm3();
	}

	@GetMapping(value = "/first")
	public String first() {
		return "type02/first";
	}

	/*
	 * @ModelAttributeにて初期化したセッションオブジェクトをハンドラの引数で取得⇒セッションに登録される
	 * @ModelAttributeアノテーションも省略できる
	 */
	@PostMapping(value = "/second-post")
	public String secondPost(HogeForm1 form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type02/second";
	}

	@GetMapping(value = "/second")
	public String second() {
		return "type02/second";
	}

	@PostMapping(value = "/third-post")
	public String thirdPost(@ModelAttribute HogeForm2 form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type02/third";
	}

	@GetMapping(value = "/third")
	public String third() {
		return "type02/third";
	}

	@PostMapping(value = "/confirm-post")
	public String confirmPost(@ModelAttribute HogeForm3 form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type02/confirm";
	}

	@GetMapping(value = "/confirm")
	public String confirm() {
		return "type02/confirm";
	}

	@GetMapping(value = "/complete")
	public String complete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "type02/complete";
	}
}
