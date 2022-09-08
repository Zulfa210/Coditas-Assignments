/**
 * @author Zulfa Attar
 */
public class Student {

    public int studentId;
    public String studentName;
    public String studentYear;;
    public float studentPercentage;
    public String studentCity;

    public String studentGender;


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentYear='" + studentYear + '\'' +
                ", studentPercentage=" + studentPercentage +
                ", studentCity='" + studentCity + '\'' +
                ", studentGender='" + studentGender + '\'' +
                '}';
    }

    public Student(int studentId, String studentName, String studentYear, float studentPercentage, String studentCity, String studentGender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.studentPercentage = studentPercentage;
        this.studentCity = studentCity;
        this.studentGender = studentGender;
    }



}

