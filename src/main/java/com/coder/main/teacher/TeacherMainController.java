package com.coder.main.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacherMain")
public class TeacherMainController {

   @GetMapping
   public String showPage(Model model) {

      return "teacher/teacherMain";
   }
}
