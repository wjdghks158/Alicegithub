package ac.kr.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginOffer(@RequestParam(value="error", required=false) String error, Model model) {
		//model.addAttribute("offers", new Offer());
		System.out.println("loginµ·´Ù");
		
		if(error != null) {
			System.out.println("!!!!!!!!!!!!!!!");
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		else {System.out.println("asdasd");
		}
		
		
		return "login";
	}
	
	
	@RequestMapping("/dologin")
	public String doLogin(Model model) {
		//model.addAttribute("offers", new Offer());
		System.out.println("dologinµ·´Ù");
		
		return "home";
	}
	

}
