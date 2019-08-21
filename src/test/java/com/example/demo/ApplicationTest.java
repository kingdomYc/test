package com.example.demo;

import com.example.demo.controller.BlogProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)

@SpringBootTest
public class ApplicationTest{

    @Autowired
    private BlogProperty blogProperties;

    @Test
    public	void getHello()	throws	Exception	{
        System.out.println(blogProperties.getName());
        System.out.println(blogProperties.getTitle());
        System.out.println(blogProperties.getName().equals("kingdomYc"));
        System.out.println(blogProperties.getTitle().equals("Spring	Boot Learning"));
    }
}
