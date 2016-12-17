package spittr.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.entities.Spitter;

@Controller
public class HomeController {
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	/**
	 * 注册界面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		model.addAttribute(new Spitter());
		return "registerForm";
		
	}
	/**
	 * 注册spitter
	 * @param spitter
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter,Errors errors){
		if(errors.hasErrors()){
			return "registerForm";
		}
		return "redirect:/spitterList";
	}
	/**
	 * 显示spitter列表
	 * @return
	 */
	@RequestMapping(value="/spitterList",method=RequestMethod.GET)
	public String showSpitterList(){
		return "spitterList";
	}
}
