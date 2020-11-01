package com.coder.main.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminMain")
public class AdminMainController {

   @GetMapping
   public String showPage(Model model) {

      return "admin/adminMain";
   }
}
