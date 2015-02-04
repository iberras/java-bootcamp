package com.sql.test;

import java.sql.SQLException;

import org.junit.Test;

import com.sql.topic5.ConnectionManager;
import com.sql.topic5.TeacherDAO;
import com.sql.topic5.TeacherDAOFactory;
import com.sql.topic5.TeacherDB;

public class DBNewTest {

	@Test
	public void testTeacherWithNewDesign() throws Exception{
		ConnectionManager manager = ConnectionManager.getInstance();
		manager.loadFile("scriptCreation.sql");
		TeacherDAO teacherDAO = TeacherDAOFactory.getTeacherDAO("mysql");
		System.out.println(teacherDAO.getSchedule(1));
	}
}
