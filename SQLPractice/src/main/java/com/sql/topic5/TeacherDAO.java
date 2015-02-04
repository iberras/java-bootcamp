package com.sql.topic5;

import java.util.List;

public interface TeacherDAO {
	public Teacher getTeacherByID(int id);
	public List<Teacher> getAllTeachers();
	public String getSchedule(int id);
}
