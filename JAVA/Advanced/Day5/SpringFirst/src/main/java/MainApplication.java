import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {

        System.out.println("****************USING SPRING***********************");
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfiguration.xml");
       Student student = (Student) context.getBean("student");
       student.display();
    }
}
/*
Output:

Id: 11
Name: Zulfa Attar
Street Name: Golf Club Road
City Name: Pune
State Name: Maharashtra
Pincode: 411006

 */