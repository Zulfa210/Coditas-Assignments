package dao;

import bean.Student;
import bean.Subject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class DaoOperationsImplementation implements DaoOperations {

    JdbcTemplate jdbcTemplate ;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertStudent(Student student) {
        return jdbcTemplate.update("insert into student values (?,?,?,?)",student.getStudentId(),student.getStudentName(),student
                .getStudentMobileNo(),student.getStudentCity());
    }

    @Override
    public int insertSubject(Subject subject) {
        return jdbcTemplate.update("insert into subject values (?,?)",subject .getSubjectId(),subject.getSubjectName());
    }

    @Override
    public int insertSubjectMarks(int studentId, int subjectId, float subjectMarks) {
        return jdbcTemplate.update("insert into subject_marks values (?,?,?)", studentId, subjectId, subjectMarks);
    }

    @Override
    public int deleteStudent(int studentId) {
        return 0;
    }

    @Override
    public int updateStudent(int studentId, float studentMarks) {
        return 0;
    }

    @Override
    public List<List<Student>> showStudentData() {

        String allStudentsQuery = "select * from student";

        List<List<Student>> totalList = new ArrayList<>();

        totalList  = jdbcTemplate.query(allStudentsQuery, new RowMapper<List<Student>>() {
            @Override
            public List<Student> mapRow(ResultSet resultSet, int i) throws SQLException {
                int studentId = resultSet.getInt(1);

                String sqlQuery = "select s.student_id, s.student_name, s.student_mobile_no, s.student_city,su.subject_id, " +
                        "su.subject_name, sm.subject_marks from student s inner join subject_marks sm on s.student_id = sm.student_id " +
                        "inner join subject su on sm.subject_id =su.subject_id where s.student_id = " + studentId;
                List<Student> students = (List<Student>) jdbcTemplate.query(sqlQuery, new ResultSetExtractor<List<Student>>() {
                    @Override
                    public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        List<Student> studentArrayList = new ArrayList<>();
                        Student student = new Student();
                        List<Subject> subjectList = new ArrayList<>();
                        while (resultSet.next()) {

                            student.setStudentId(resultSet.getInt(1));
                            student.setStudentName(resultSet.getString(2));
                            student.setStudentMobileNo(resultSet.getLong(3));
                            student.setStudentCity(resultSet.getString(4));
                            Subject subject = new Subject();
                            subject.setSubjectId(resultSet.getInt(5));
                            subject.setSubjectName(resultSet.getString(6));
                            subject.setSubjectMarks(resultSet.getFloat(7));
                            subjectList.add(subject);
                        }

                        student.setSubjectList(subjectList);

                        studentArrayList.add(student);

                        return studentArrayList;
                    }
                });
                return students;

        }
        });

    return totalList;

    }

}
