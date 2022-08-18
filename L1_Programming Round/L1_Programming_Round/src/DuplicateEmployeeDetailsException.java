/**
 * @author Zulfa Attar
 */
public class DuplicateEmployeeDetailsException extends Exception{
    DuplicateEmployeeDetailsException(String message){
        System.out.println(message+ "Employee ID already exists");
    }
}
