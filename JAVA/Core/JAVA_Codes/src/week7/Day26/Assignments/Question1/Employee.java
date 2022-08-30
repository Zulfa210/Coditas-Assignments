package week7.Day26.Assignments.Question1;

/**
 * @author Zulfa Attar
 */
public class Employee {
    int employeeId;
    String employeeName;
    String Designation;
    String dateOfJoining;
    int employeeExperience;
    float salary;

    public Employee(int employeeId, String employeeName, String designation, String dateOfJoining, int employeeExperience, float salary, String status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        Designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.employeeExperience = employeeExperience;
        this.salary = salary;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\nemployeeId=" + employeeId +
                "\n employeeName='" + employeeName + '\'' +
                "\nDesignation='" + Designation + '\'' +
                "\ndateOfJoining='" + dateOfJoining + '\'' +
                "\nemployeeExperience=" + employeeExperience +
                "\nsalary=" + salary +
                "\nstatus='" + status + '\'' +
                '}';
    }

    String status;

}
