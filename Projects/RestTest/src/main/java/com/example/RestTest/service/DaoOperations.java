package com.example.RestTest.service;

import com.example.RestTest.entities.Teacher;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {

    public void insertTeacher(Teacher teacher);

   public List<Teacher> showTeachers();

   public void deleteTeacher(int teacherId);

   public void updateTeacher(Teacher teacher);
}
