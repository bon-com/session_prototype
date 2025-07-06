package com.example.prototype.web.controller.type01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.prototype.web.dto.type01.HogeForm;

/*
 * @SessionAttributesを使用して同一クラス内のセッションを管理する
 */
@Controller
@RequestMapping(value = "type01")
@SessionAttributes(types = HogeForm.class)
public class Type01Controller {

	private static final Logger logger = LoggerFactory.getLogger(Type01Controller.class);
	
	/*
	 * typesでセッションを保持する型を指定しているため、HogeFormの型がセッションで管理される
	 * そのため、@ModelAttribute(name="xxx")のキー指定は不要
	 * キーは「hogeForm（クラス名の先頭小文字）」が自動設定される
	 */
	@ModelAttribute 
	public HogeForm setUpForm() {
		return new HogeForm();
	}

	@GetMapping(value = "/first")
	public String first() {
		return "type01/first";
	}

	/* 
	 * @ModelAttributeにて初期化したセッションオブジェクトをハンドラの引数で取得⇒セッションに登録される
	 * @ModelAttributeアノテーションも省略できる
	 */
	@PostMapping(value = "/second-post")
	public String secondPost(HogeForm form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type01/second";
	}
	
	@GetMapping(value = "/second")
	public String second() {
		return "type01/second";
	}

	@PostMapping(value = "/third-post")
	public String thirdPost(@ModelAttribute("hogeForm") HogeForm form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type01/third";
	}
	
	@GetMapping(value = "/third")
	public String third() {
		return "type01/third";
	}
	
	@PostMapping(value = "/confirm-post")
	public String confirmPost(@ModelAttribute("hogeForm") HogeForm form) {
		logger.debug("★セッション確認★： {}\n", form);
		return "redirect:/type01/confirm";
	}
	
	@GetMapping(value = "/confirm")
	public String confirm() {
		return "type01/confirm";
	}
	
	@GetMapping(value = "/complete")
	public String complete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "type01/complete";
	}
}
