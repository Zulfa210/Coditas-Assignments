import java.util.Map;
import java.util.Set;

/**
 * @author Zulfa Attar
 */
public class Director {
    String directorName;
    Set<Movie> movies;

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorName='" + directorName + '\'' +
                ", movies=" + movies +
                '}';
    }

    Director(){

    }

    public void Display(){
        System.out.println("Director name: " + getDirectorName());

        Set<Movie> movieMap = getMovies();
        for(Movie m : movieMap){
            System.out.println(m);
        }

    }
}
