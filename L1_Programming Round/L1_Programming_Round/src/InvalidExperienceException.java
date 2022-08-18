/**
 * @author Zulfa Attar
 */
public class InvalidExperienceException  extends Exception{
    InvalidExperienceException(String message){
        System.out.println(message + "Experience should be greater than 5 years");
    }
}
