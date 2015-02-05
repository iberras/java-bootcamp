package com.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Teacher;
import com.entities.TeacherDAO;
import com.entities.TeacherManager;

@Service
public class TeacherManagerImpl implements TeacherManager {

  @Autowired
  private TeacherDAO teacherDAO;

	@Override
	public Teacher getTeacherByID(int id) {
		return teacherDAO.getTeacherByID(id);
	}
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDAO.getAllTeachers();
	}
	
	@Override
	public String getSchedule(int id) {
		return teacherDAO.getSchedule(id);
	}

}
