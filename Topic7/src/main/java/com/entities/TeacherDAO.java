package com.entities;

import java.util.List;

public interface TeacherDAO {
	public Teacher getTeacherByID(int id);
	public List<Teacher> getAllTeachers();
	public String getSchedule(int id);
}
