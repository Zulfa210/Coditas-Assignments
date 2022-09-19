import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("SpringBean.xml", "RectangleBean.xml", "CircleBean.xml");

        Triangle triangle = (Triangle) context.getBean("triangle1");
        System.out.println(triangle);
        System.out.println(new AreaClass().calculateArea(triangle));

        Rectangle rectangle = (Rectangle) context.getBean("rect");
        System.out.println(rectangle);

        Circle circle = (Circle) context.getBean("circle1");
        System.out.println(circle);

        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CircleBean.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("InnerBean.xml");


        Shape shape = (Shape) applicationContext.getBean("shape");
        shape.display();

    }
}
