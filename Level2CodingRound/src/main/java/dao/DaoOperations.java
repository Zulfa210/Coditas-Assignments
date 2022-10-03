package dao;

import bean.Student;
import bean.Subject;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {

    public int insertStudent(Student student);
    public int insertSubject(Subject subject);


    int insertSubjectMarks(int studentId, int subjectId, float subjectMarks);


    public int deleteStudent(int studentId);
    public int updateStudent(int studentId, float studentMarks);

    List<List<Student>> showStudentData();
}
