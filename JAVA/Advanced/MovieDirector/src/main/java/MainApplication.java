import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
        Director director = context.getBean("director", Director.class);
        director.Display();
    }
}

/*
Output:
Director name: Anthony Russo
Movie{movieName='The Avengers', boxOfficeCollection=1500, budget=300.0}
Movie{movieName='Avengers Endgame', boxOfficeCollection=1600, budget=200.0}
Movie{movieName='Avengers Infinity', boxOfficeCollection=2500, budget=100.0}

Process finished with exit code 0
 */