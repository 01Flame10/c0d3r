package com.coder.main.editor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/codeEditor")
public class CoderEditorMainController {

    @GetMapping
    public String getStatic(Model model) {
        return "student/editor/index";
    }
}
