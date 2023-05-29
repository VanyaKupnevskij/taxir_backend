package com.taxir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/")
@Controller
@CrossOrigin
public class WebController extends ServiceController {

    @GetMapping("/")
    public String main() {

        return "index";
    }
}
