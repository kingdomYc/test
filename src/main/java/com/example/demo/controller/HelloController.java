package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public	String	index(@RequestParam String name)	{
            //	加⼊⼀个属性，⽤来在模板中读取
//            map.addAttribute("host",	"http://blog.didispace.com");
//            //	return模板⽂件的名称，对应src/main/resources/templates/index.html
//            return	"index";

            return "Hello " + name;
        }
    }
