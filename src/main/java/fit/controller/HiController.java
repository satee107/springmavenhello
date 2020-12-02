package fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fit.model.User;

@Controller
public class HiController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoIndex(Model model)
	{
		System.out.println("home page triggerd");
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name, Model model) {
		System.out.println("welcome to "+name);
		model.addAttribute("name",name);
		return "hello";
	}
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable("name") String name, Model model) {
		System.out.println("welcome to "+name);
		model.addAttribute("name",name);
		return "hello";
	}
	
	
	@PostMapping("/displayuser")
	public String displayuser(@ModelAttribute User user,Model model) {
		model.addAttribute("uname",user.getUname());
		model.addAttribute("address",user.getAddress());
		return "user";
	}

}
