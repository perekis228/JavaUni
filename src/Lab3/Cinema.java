package Lab3;
import java.util.ArrayList;

public class Cinema {
    private ArrayList<Hall> halls = new ArrayList<>();
    private String adress;

    public Cinema(String adress){
        this.adress = adress;
    }

    public void add_hall(int horizontal, int vertical){
        this.halls.add(new Hall(horizontal, vertical));
    }

    public void add_movie(int hall_num, String movie_name, String movie_time, int movie_duration){
        this.halls.get(hall_num).add_movie(movie_name, movie_time, movie_duration);
    }

    public void take_seat(int hall_num, int moovie_num, int horizontal, int vertical){
        this.halls.get(hall_num).take_seat(moovie_num, horizontal, vertical);
    }

    public String[] find_close(){
        String[] good_movie = new String[4];
        for (int i = 0; i < this.halls.size(); i++){
            String[] cur_movie = this.halls.get(i).find_close();
            if (good_movie[1] == null ||
                    Integer.parseInt(good_movie[1].substring(0, 2)) > Integer.parseInt(cur_movie[1].substring(0, 2)) ||
                    Integer.parseInt(good_movie[1].substring(0, 2)) == Integer.parseInt(cur_movie[1].substring(0, 2)) &&
                    Integer.parseInt(good_movie[1].substring(3)) > Integer.parseInt(cur_movie[1].substring(3))){
                good_movie[0] = cur_movie[0];
                good_movie[1] = cur_movie[1];
                good_movie[2] = cur_movie[2];
                good_movie[3] = String.valueOf(i+1);
            }
        }
        return good_movie;
    }

    public ArrayList<Hall> get_halls(){
        return new ArrayList<>(this.halls);
    }

    @Override
    public String toString() {
        return this.adress;
    }
}
