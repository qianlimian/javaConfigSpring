package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@RequestParam("picture") MultipartFile file,@Valid Spitter spitter,Errors errors) throws IllegalStateException, IOException{
		if(errors.hasErrors()){
			return "registerForm";
		}
		file.transferTo(new File("c:\\temp\\"+file.getOriginalFilename()));
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
