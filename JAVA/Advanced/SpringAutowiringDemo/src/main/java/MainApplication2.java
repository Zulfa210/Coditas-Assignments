import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zulfa Attar
 */
public class MainApplication2 {
    public static void main(String[] args) {

        ApplicationContext a = new ClassPathXmlApplicationContext("getBean.xml");



        System.out.println("===============================");
        Employee employee1 = (Employee) a.getBean("employee");
        System.out.println(employee1);

        System.out.println("===============================");
        Employee employee2 = a.getBean(Employee.class);
        System.out.println(employee2);
        Address address = employee2.getEmployeeAddress();

        System.out.println("===============================");
        Employee employee4 = (Employee) a.getBean("employee", Employee.class);
        System.out.println(employee4);

        System.out.println("===============================");
        Employee employee3 = (Employee) a.getBean("employee",122,"Zulfa",address);
        System.out.println(employee3);





    }
}
