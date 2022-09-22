package com.dao;

import com.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class StudentDao {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   public int insertStudent(Student student){
        return (jdbcTemplate.update("insert into student values (?,?,?,?,?)",
                student.getStudentId(), student.getStudentName(),student.getMobileNo(),student.getStudentCity(), student.getStudentPercentage()));
   }

   public int updateStudentName(int id, String name){
        return (jdbcTemplate.update("update student set name = ? where id = ?",name,id));
   }
   public int updateStudentMobile(int id, String mobileNo){
       return (jdbcTemplate.update("update student set mobileno = ? where id = ?",mobileNo,id));

   }
   public int updateStudentCity(int id, String city){
       return (jdbcTemplate.update("update student set city = ? where id = ?",city,id));
   }
   public int updateStudentPercentage(int id, float percentage){
       return (jdbcTemplate.update("update student set percentage = ? where id = ?",percentage,id));
   }
   public int deleteStudent(int studentID){
        return (jdbcTemplate.update("delete from student where id = ?", studentID));
   }
   public List<Student> fetchAllStudents(){
        String selectQuery = "select * from student";
        List<Student> list = jdbcTemplate.query(selectQuery, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setMobileNo(resultSet.getString(3));
                student.setStudentCity(resultSet.getString(4));
                student.setStudentPercentage(resultSet.getFloat(5));
                return student;
            }
        });
        return list;
   }
}
