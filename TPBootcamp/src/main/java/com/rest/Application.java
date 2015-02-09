package com.rest;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.User;
import com.services.UserServiceImpl;


public class Application {

    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(
    	        "spring.xml");

    	    UserServiceImpl userManager = (UserServiceImpl) ctx.getBean("userServiceImpl");

    	    boolean login = userManager.login("Facu", "12345678");
    	    if(login)
    	    	System.out.println("Facu se logeo");
    	    else
    	    	System.out.println("Facu NO SE LOGEO");

    }
}
