package com.topic7;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Teacher;
import com.entities.TeacherManager;


public class Application {

    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(
    	        "spring.xml");

    	    TeacherManager teacherManager = (TeacherManager) ctx.getBean("teacherManagerImpl");

    	    List<Teacher> list = teacherManager.getAllTeachers();
    	    System.out.println("Teacher count: " + list.size());

    }
}
