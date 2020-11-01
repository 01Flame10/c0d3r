package com.coder.main.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/studentMain")
public class StudentMainController {

   @GetMapping
   public String showPage(Model model) {

      return "student/studentMain";
   }
}
