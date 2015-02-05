package com.entities.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.Teacher;
import com.entities.TeacherDAO;

@Repository
public class TeacherImp implements TeacherDAO{

	@PersistenceContext
	private EntityManager entityManager;
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public TeacherImp(){
	}
	
	public Teacher getTeacherByID(int id) {
		Query q1 = (Query) entityManager.createQuery("SELECT t  "
				+ "from Teacher t "
				+ "where  (t.id = "+ Integer.toString(id) + ") ");
				
		Teacher queryResult = (Teacher) q1.getSingleResult();
		return queryResult;
	}

	public List<Teacher> getAllTeachers() {
		Query q1 = (Query) entityManager.createQuery("SELECT t "
				+ "from Teacher t");
				
		List<Teacher> queryResult = q1.getResultList();
		return queryResult;
	}

	public String getSchedule(int id) {
		/*
		Query q1 = (Query) entityManager.createQuery("SELECT c.name, t.firstName, t.lastName , DATE_FORMAT(s.HourStart,'%W') as dia, time(s.HourStart) as horai, time(s.HourEnd) as houre "
														+ "from Schedule s, Teacher t, Course c "
														+ "where  (t.id = "+ Integer.toString(id) + ") and (c.idAssignedTeacher = t.id) and (s.idSchedule = c.idSchedule) "
														+ "group by c.name "
														+ "Order by s.HourStart");
		StringBuilder result = new StringBuilder();
		List queryResult = q1.getResultList();
		result.append("Teacher: "+ ((Object[])queryResult.get(0))[1] + ", "+ ((Object[])queryResult.get(0))[2]);
		result.append(NEWLINE);
		result.append("Schedule: ");
		result.append(NEWLINE);
		for(int i = 1; i < queryResult.size(); i++){
			result.append(((Object[])queryResult.get(i))[3]+ ", "+((Object[])queryResult.get(i))[4] + ", " +((Object[])queryResult.get(i))[5] + " " + ((Object[])queryResult.get(i))[0]);
			result.append(NEWLINE);
		}
		return result.toString();
		*/
		return null;
	}
}
