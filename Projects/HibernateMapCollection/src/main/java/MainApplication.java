import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {


        SessionFactory sessionFactory  =  new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count;
        System.out.println("Enter no. of teams: ");
        count = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i< count; i++){
            IPL_team_details team = new IPL_team_details();
            System.out.println("Enter team name and owner name");
            team.setTeam_name(bufferedReader.readLine());

            team.setOwner_name(bufferedReader.readLine());
            System.out.println("Enter no of Players: ");
            int noOfPlayers = Integer.parseInt(bufferedReader.readLine());

            Map<String,Players> players = new HashMap<>();
            for(int j =0; j<noOfPlayers; j++){
                Players player = new Players();
                System.out.println("Enter jersey no, player name and bid value of player");
                player.setJno(Integer.parseInt(bufferedReader.readLine()));
                player.setName(bufferedReader.readLine());
                player.setBid_value(Integer.parseInt(bufferedReader.readLine()));

                System.out.println("Enter country name");
                String country = bufferedReader.readLine();
                players.put(country, player);
            }

            team.setPlayers(players);

            session.save(team);
            transaction.commit();
        }


    }
}
