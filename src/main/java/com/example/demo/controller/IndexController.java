package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public	String	index()	{
        return	"index2";
    }
    @RequestMapping("/hello2")
    public	String	hello()	{
        return	"hello2";
    }
    @RequestMapping("/login")
    public	String	login()	{
        return	"login";
    }
}
