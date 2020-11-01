package com.coder.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

   @GetMapping
   public String processLogout(HttpServletRequest request, Model model) {
	   
	  HttpSession session = request.getSession();

	  session.invalidate();

      return "redirect:/";
   }
   
   @PostMapping
   public String processLogoutPost(HttpServletRequest request, Model model) {

	  HttpSession session = request.getSession();

	  session.invalidate();

      return "redirect:/";
   }   
}