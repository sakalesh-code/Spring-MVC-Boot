package com.learn.sprinmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learn.sprinmvcboot.model.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}

//	@GetMapping("/add")
//	public String add(HttpServletRequest request) {
//		int num1 = Integer.parseInt(request.getParameter("num1"));
//		int num2 = Integer.parseInt(request.getParameter("num2"));
//		int num3 = num1 + num2;
//		System.out.println(num3);
//		HttpSession session = request.getSession();
//		session.setAttribute("num3", num3);
//
//		return "view";
//	}

//	@GetMapping("/add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session) {// Using HttpSession
//		int num3 = i + j;
//		System.out.println(num3);
//		session.setAttribute("num3", num3);
//
//		return "result";
//	}

//	@GetMapping("/add")
//	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {// Using ModelAndView
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		int num3 = i + j;
//		mv.addObject("num3", num3);
//
//		return mv;
//	}

//	@GetMapping("/add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) { // Using Model interface
//		int num3 = i + j;
//		m.addAttribute("num3", num3);
//
//		return "result";
//	}

	@GetMapping("/add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) { // Using ModelMap
		int num3 = i + j;
		m.addAttribute("num3", num3);

		return "result";
	}

//	@GetMapping("/addAlien")
//	public String add(@RequestParam int aid, @RequestParam String name, ModelMap m) { // Using ModelMap
//		Alien a = new Alien();
//		a.setAid(aid);
//		a.setName(name);
//		m.addAttribute("alien", a);
//
//		return "result";
//	}

//	@GetMapping("/addAlien")
//	public String add(Alien a, ModelMap m) { // Using ModelMap
//		m.addAttribute("alien", a);
//
//		return "result";
//	}

//	@GetMapping("/addAlien")
//	public String add(Alien a) { //  same name 
//
//		return "result";
//	}

	@GetMapping("/addAlien")
	public String add(@ModelAttribute("alien") Alien a) { // Using ModelMap

		return "result";
	}

	@ModelAttribute
	public void show(Model m) {
		m.addAttribute("guys", "Aliens");
	}

//	Feature	            		@ModelAttribute	           		 		  @RequestParam
//	Binding				Binds to an entire object					Binds to individual parameters
//	Complexity			Suitable for complex data (objects)			Suitable for simple data (primitives)
//	Data Types			Supports automatic type conversion			Limited to strings and simple types
//	Validation			Can use validation annotations				No built-in validation
//	Use Case			Form submissions with multiple fields		Simple parameter retrieval
}
