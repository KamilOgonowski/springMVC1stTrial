package com.kamil.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		System.out.println("home page requested");
		return "index.jsp";
	}
//	@RequestMapping("add")
//	public String add(HttpServletRequest req ) {
//		
//		int num1jsp = Integer.parseInt(req.getParameter("num1"));
//		int num2jsp = Integer.parseInt(req.getParameter("num2"));
//		int num3 = num1jsp + num2jsp;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("num3", num3);
//		
//		
//		return "result.jsp";
//	}
	
//	// 2nd option converting reducing lines used by servlets
//	@RequestMapping("add")
//	public String add(HttpSession session, @RequestParam("num1") int i,@RequestParam("num2") int j) {
//
//		int num3 = i + j;
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//	}
	
	// converting towards Spring -> ModelAndView instead of direct usage of Servlets
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {

		ModelAndView mv = new ModelAndView();
		int num3 = i + j;
		mv.addObject("num3", num3);
		mv.setViewName("result.jsp");
	
		return mv;
	}
}
