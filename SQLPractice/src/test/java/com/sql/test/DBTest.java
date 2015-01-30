package com.sql.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.sql.topic5.DBManager;

public class DBTest {

	@Test
	public void testConnection() throws ClassNotFoundException, SQLException {
		DBManager manager = new DBManager();
		manager.connect();
		manager.closeConnection();
	}
	
	@Test
	public void testFileLoad() throws Exception {
		DBManager manager = new DBManager();
		manager.connect();
		manager.loadFile("scriptCreation.sql");
		manager.closeConnection();
	}
	
	@Test
	public void testQueryStudentAndTeachers() throws Exception{
		DBManager manager = new DBManager();
		manager.connect();
		manager.loadFile("scriptCreation.sql");
		System.out.println(manager.getStudentAndTEachersFromCourse("Matematica"));
		manager.closeConnection();
	}
	
	@Test
	public void testQueryFinalNoteForStudent() throws Exception{
		DBManager manager = new DBManager();
		manager.connect();
		manager.loadFile("scriptCreation.sql");
		System.out.println(manager.getFinalNoteForStudent("1"));
		manager.closeConnection();
	}
	
	@Test
	public void testQueryPercentageOfStudentsPassed() throws Exception{
		DBManager manager = new DBManager();
		manager.connect();
		manager.loadFile("scriptCreation.sql");
		System.out.println(manager.percentageOfStudentsPassed("Lengua"));
		manager.closeConnection();
	}
	
	@Test
	public void testQueryTeacherSchedule() throws Exception{
		DBManager manager = new DBManager();
		manager.connect();
		manager.loadFile("scriptCreation.sql");
		System.out.println(manager.getTeacherSchedule("3"));
		manager.closeConnection();
	}

}
