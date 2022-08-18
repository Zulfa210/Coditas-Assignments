/**
 * @author Zulfa Attar
 */
public class InvalidEmployeeIDException  extends Exception{
    InvalidEmployeeIDException(String message){
        System.out.println(message + "Employee  Id should be between 1000 -2000");
    }
}
