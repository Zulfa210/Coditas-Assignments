package bean;

/**
 * @author Zulfa Attar
 */
public class Subject {

    private int subjectId;
    private String subjectName;

    private float subjectMarks;

    public float getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(float subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
