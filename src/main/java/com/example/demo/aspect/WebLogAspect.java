package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass().toString());
}
