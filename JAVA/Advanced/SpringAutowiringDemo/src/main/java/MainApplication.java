import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zulfa Attar
 */
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext("ByName.xml");
        //ApplicationContext a = new ClassPathXmlApplicationContext("constructor.xml");

        Student student
                 = (Student) a.getBean("student");
        System.out.println(student);

        System.out.println("===============================");
        Employee employee = (Employee) a.getBean("employee");
        System.out.println(employee);
    }
}
