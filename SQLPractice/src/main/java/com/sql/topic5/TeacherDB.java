package com.sql.topic5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TeacherDB implements TeacherDAO{

	private static final String NEWLINE = System.getProperty("line.separator");
	private final Connection connection;
	
	public TeacherDB(Connection connection){
		this.connection = connection;
	}
	
	public Teacher getTeacherByID(int id) {
		try {
			Statement statement = connection.createStatement();
		
		ResultSet queryResult = statement.executeQuery("SELECT COUNT(*)  "
														+ "from Teacher"
														+ "where  (Teacher.id = \""+ Integer.toString(id) + "\") "
														+ ";");
		queryResult.next();
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(queryResult.getString("Teacher.id")));
		teacher.setFistName(queryResult.getString("Teacher.firstName"));
		teacher.setLastName(queryResult.getString("Teacher.lastName"));
		teacher.setDateOfBirth(queryResult.getString("Teacher.dateOfBirth"));
		return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Teacher> getAllTeachers() {
		try {
			Statement statement = connection.createStatement();
		
		ResultSet queryResult = statement.executeQuery("SELECT COUNT(*)  "
														+ "from Teacher"
														+ ";");

		List<Teacher> teachers = new ArrayList<Teacher>();
		queryResult.next();
		do{
			Teacher teacher = new Teacher();
			teacher.setId(Integer.parseInt(queryResult.getString("Teacher.id")));
			teacher.setFistName(queryResult.getString("Teacher.firstName"));
			teacher.setLastName(queryResult.getString("Teacher.lastName"));
			teacher.setDateOfBirth(queryResult.getString("Teacher.dateOfBirth"));
			teachers.add(teacher);
		}
		while(queryResult.next());
		return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSchedule(int id) {
		try {
			Statement statement = connection.createStatement();
		
		ResultSet queryResult = statement.executeQuery("SELECT Course.name, Teacher.firstName, Teacher.lastName , DATE_FORMAT(Schedule.HourStart,'%W') as dia, time(Schedule.HourStart) as horai, time(Schedule.HourEnd) as houre "
														+ "from Schedule, Teacher, Course "
														+ "where  (Teacher.id = \""+ Integer.toString(id) + "\") and (Course.idAssignedTeacher = Teacher.id) and (Schedule.idSchedule = Course.idSchedule)"
														+ "group by Course.name "
														+ "Order by Schedule.HourStart;");
		StringBuilder result = new StringBuilder();
		queryResult.next();
		result.append("Teacher: "+ queryResult.getString("Teacher.lastName") + ", "+ queryResult.getString("Teacher.firstName"));
		result.append(NEWLINE);
		result.append("Schedule: ");
		result.append(NEWLINE);
		do{
			result.append(queryResult.getString("dia")+ ", "+queryResult.getString("horai") + ", " +queryResult.getString("houre") + " " + queryResult.getString("Course.name"));
			result.append(NEWLINE);
		}while(queryResult.next());
		statement.close();
		queryResult.close();
		return result.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
