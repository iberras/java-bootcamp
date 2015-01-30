package com.sql.topic5;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBManager {
	private static final String newLine = System.getProperty("line.separator");
	private static Connection connection;

	public void connect() throws ClassNotFoundException, SQLException {
		String driverName = "org.gjt.mm.mysql.Driver";
	    Class.forName(driverName);

	    String serverName = "localhost";
	    String mydatabase = "";
	    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 

	    String username = "root";
	    String password = "";
	    connection = DriverManager.getConnection(url, username, password);
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public void loadFile(String path) throws Exception {
		ScriptRunner runner = new ScriptRunner(connection, false, true);
		runner.runScript(new BufferedReader(new FileReader(path)));
	}

	public static String getStudentAndTEachersFromCourse(String course) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet queryResult = statement.executeQuery("select Course.name, Teacher.firstName, Teacher.lastname, Student.firstName, Student.lastName "
				+ "from Course, Teacher, Student, Notas where (Course.name =\""+course +"\") and (Course.idCourse = Notas.idCourse) and "
						+ "(Course.idAssignedTeacher = Teacher.id) and (Notas.idStudent = Student.registrationNumber) order by Student.lastName;");
		StringBuilder result = new StringBuilder();
		queryResult.next();
		result.append("Course: "+ course);
		result.append(newLine);
		result.append("Teacher : "+ queryResult.getString("Teacher.lastname")+ ", "+ queryResult.getString("Teacher.firstName"));
		result.append(newLine);
		result.append("Students:");
		do{
			result.append(newLine);
			result.append(queryResult.getString("Student.lastName") + ", "+ queryResult.getString("Student.firstName") );
		}while(queryResult.next());
		statement.close();
		queryResult.close();
		return result.toString();
	}
	
	public static String getFinalNoteForStudent (String student) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet queryResult = statement.executeQuery("select Student.lastName, Student.firstName, Course.name, Notas.finalNote "
														+"from Student, Course, Notas "
														+"where (Student.registrationNumber = \""+student +"\") and (Notas.idStudent = Student.registrationNumber) and (Course.idCourse = Notas.idCourse) "
														+"order by Notas.finalNote, Course.name;");
		StringBuilder result = new StringBuilder();
		queryResult.next();
		result.append("Student: "+ queryResult.getString("Student.lastName") + ", "+ queryResult.getString("Student.firstName"));
		result.append(newLine);
		do{
			result.append("Course : "+ queryResult.getString("Course.name")+ ": Final Note "+queryResult.getString("Notas.finalNote"));
			result.append(newLine);
		}while(queryResult.next());
		statement.close();
		queryResult.close();
		return result.toString();
	}
	
	public static String percentageOfStudentsPassed(String course) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet queryResult = statement.executeQuery("SELECT AVG(a.scount) as average "
													   +"FROM (select count(*) as scount "
													   +"from Notas, Course, Student "
													   +"where (Notas.idCourse = Course.idCourse)and (Course.name = \""+course+"\") and (Student.registrationNumber = Notas.idStudent) "
													   +"and (Notas.finalNote >= 4) GROUP BY Course.name) a;"); 
		StringBuilder result = new StringBuilder();
		queryResult.next();
		result.append("Course: "+ course + ", Average: "+ queryResult.getString("average"));
		statement.close();
		queryResult.close();
		return result.toString();
	}

	public static String getTeacherSchedule (String teacher) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet queryResult = statement.executeQuery("SELECT Course.name, Teacher.firstName, Teacher.lastName , DATE_FORMAT(Schedule.HourStart,'%W') as dia, time(Schedule.HourStart) as horai, time(Schedule.HourEnd) as houre "
														+ "from Schedule, Teacher, Course "
														+ "where  (Teacher.id = \""+ teacher + "\") and (Course.idAssignedTeacher = Teacher.id) and (Schedule.idSchedule = Course.idSchedule)"
														+ "group by Course.name "
														+ "Order by Schedule.HourStart;");
		StringBuilder result = new StringBuilder();
		queryResult.next();
		result.append("Teacher: "+ queryResult.getString("Teacher.lastName") + ", "+ queryResult.getString("Teacher.firstName"));
		result.append(newLine);
		result.append("Schedule: ");
		result.append(newLine);
		do{
			result.append(queryResult.getString("dia")+ ", "+queryResult.getString("horai") + ", " +queryResult.getString("houre") + " " + queryResult.getString("Course.name"));
			result.append(newLine);
		}while(queryResult.next());
		statement.close();
		queryResult.close();
		return result.toString();
	}
}
