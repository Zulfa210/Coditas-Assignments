package Dao;

/**
 * @author Zulfa Attar
 */
public class Teacher {
    int teacherId;
    String teacherUsername;
    String teacherPassword;
    String teacherName;
    String teacherAboutMe;
    String teacherTestimonial;
    String teacherAge;
    String teacherAddress;
    String teacherDateOfJoining;
    String teacherMobileNo;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAboutMe() {
        return teacherAboutMe;
    }

    public void setTeacherAboutMe(String teacherAboutMe) {
        this.teacherAboutMe = teacherAboutMe;
    }

    public String getTeacherTestimonial() {
        return teacherTestimonial;
    }

    public void setTeacherTestimonial(String teacherTestimonial) {
        this.teacherTestimonial = teacherTestimonial;
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherDateOfJoining() {
        return teacherDateOfJoining;
    }

    public void setTeacherDateOfJoining(String teacherDateOfJoining) {
        this.teacherDateOfJoining = teacherDateOfJoining;
    }

    public String getTeacherMobileNo() {
        return teacherMobileNo;
    }

    public void setTeacherMobileNo(String teacherMobileNo) {
        this.teacherMobileNo = teacherMobileNo;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAboutMe='" + teacherAboutMe + '\'' +
                ", teacherTestimonial='" + teacherTestimonial + '\'' +
                ", teacherAge='" + teacherAge + '\'' +
                ", teacherAddress='" + teacherAddress + '\'' +
                ", teacherDateOfJoining='" + teacherDateOfJoining + '\'' +
                ", teacherMobileNo='" + teacherMobileNo + '\'' +
                '}';
    }
}
