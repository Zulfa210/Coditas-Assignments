import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springBeans.xml");
            DID did = applicationContext.getBean("did", DID.class);
            did.display();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
