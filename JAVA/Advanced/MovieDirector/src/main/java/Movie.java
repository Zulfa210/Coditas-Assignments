/**
 * @author Zulfa Attar
 */
public class Movie {
    String movieName;
    int boxOfficeCollection;
    float budget;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getBoxOfficeCollection() {
        return boxOfficeCollection;
    }

    public void setBoxOfficeCollection(int boxOfficeCollection) {
        this.boxOfficeCollection = boxOfficeCollection;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", boxOfficeCollection=" + boxOfficeCollection +
                ", budget=" + budget +
                '}';
    }

    Movie(){

    }
}
