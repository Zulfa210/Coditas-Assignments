package Dao;

/**
 * @author Zulfa Attar
 */
public class Student {
    int studentId;
    String studentUsername;
    String studentPassword;
    String studentName;
    String studentAboutMe;
    String studentTestimonial;
    int studentAge;
    String studentAddress;
    String studentClass;
    String studentMobileNo;

    String studentImage;


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentUsername='" + studentUsername + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAboutMe='" + studentAboutMe + '\'' +
                ", studentTestimonial='" + studentTestimonial + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentMobileNo='" + studentMobileNo + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAboutMe() {
        return studentAboutMe;
    }

    public void setStudentAboutMe(String studentAboutMe) {
        this.studentAboutMe = studentAboutMe;
    }

    public String getStudentTestimonial() {
        return studentTestimonial;
    }

    public void setStudentTestimonial(String studentTestimonial) {
        this.studentTestimonial = studentTestimonial;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMobileNo() {
        return studentMobileNo;
    }

    public void setStudentMobileNo(String studentMobileNo) {
        this.studentMobileNo = studentMobileNo;
    }

    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }
}
