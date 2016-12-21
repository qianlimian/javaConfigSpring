package spittr.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spittr.entities.Spitter;

@Controller
public class HomeController {
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	/**
	 * ע�����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registerForm",method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		model.addAttribute(new Spitter());
		return "registerForm";
		
	}
	/**
	 * ע��spitter
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
	 * ��ʾspitter�б�
	 * @return
	 */
	@RequestMapping(value="/spitterList",method=RequestMethod.GET)
	public String showSpitterList(){
		return "spitterList";
	}
	//**********************************************************************
	/**
	 * ��ȡ����ͷ����Ϣ
	 * @description
	 * @return void
	 * @author wanghaidong
	 * @date 2016��12��21�� ����2:12:54
	 */
	@RequestMapping(value="/headerInfo",method=RequestMethod.GET)
	public String displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,
			@RequestHeader("Accept-Language") String language){
		System.out.println("Accept-Encoding: "+encoding);
		System.out.println("Accept-Language: "+language);
		return "spitterList";
	}
	/**
	 * ��ȡsession��Ϣ
	 * @description
	 * @return void
	 * @author wanghaidong
	 * @date 2016��12��21�� ����2:26:03
	 */
	@RequestMapping(value="/sessionInfo",method=RequestMethod.GET)
	public void displaySession(@CookieValue("JSESSIONID") String sessionId){
		System.out.println("JSESSIONID: "+sessionId);
	}
	/**
	 * ajax����
	 * @description
	 * @return String
	 * @author wanghaidong
	 * @date 2016��12��21�� ����2:59:32
	 */
	@RequestMapping(value="testResponseBody",method=RequestMethod.POST)
	@ResponseBody
	public List<Spitter> testResponseBody(@RequestBody List<Spitter> spitterList){
		for(Spitter spitter : spitterList){
			System.out.println(spitter.getFirstName()+" "+spitter.getLastName());
		}
		return spitterList;
	}
}
