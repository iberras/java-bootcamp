package com.topic7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entities.Teacher;
import com.entities.TeacherManager;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class Topic7ApplicationTests {

	@Test
	public void getAllTeachersTest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
    	        "spring.xml");

    	TeacherManager teacherManager = (TeacherManager) ctx.getBean("teacherManagerImpl");

    	List<Teacher> list = teacherManager.getAllTeachers();
    	assertEquals(3,list.size());
	}
	
	@Test
	public void getScheduleTest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
    	        "spring.xml");

    	TeacherManager teacherManager = (TeacherManager) ctx.getBean("teacherManagerImpl");

    	String result = teacherManager.getSchedule(0);
    	System.out.println(result);
	}
	
	//need to map other entities to test this functionality
	@Test
	public void getTeacherTest() {/*
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
    	        "spring.xml");

    	TeacherManager teacherManager = (TeacherManager) ctx.getBean("teacherManagerImpl");

    	Teacher result = teacherManager.getTeacherByID(1);
    	assertEquals("Laura",result.getFirstName());
    	*/
	}

}
