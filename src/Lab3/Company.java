package Lab3;
import java.util.ArrayList;

public class Company {
    private ArrayList<Cinema> cinemas = new ArrayList<>();

    public Company(){
    }

    public void add_cinema(String adress){
        this.cinemas.add(new Cinema(adress));
    }

    public void add_hall(int cinema_num, int horizontal, int vertical){
        Cinema cur_cinema = this.cinemas.get(cinema_num);
        cur_cinema.add_hall(horizontal, vertical);
    }

    public void add_movie(int cinema_num, int hall_num, String movie_name, String movie_time, int movie_duration){
        this.cinemas.get(cinema_num).add_movie(hall_num, movie_name, movie_time, movie_duration);
    }

    public void take_seat(int cinema_num, int hall_num, int moovie_num, int horizontal, int vertical){
        this.cinemas.get(cinema_num).take_seat(hall_num, moovie_num, horizontal, vertical);
    }

    public void find_close(){
        String[] good_movie = new String[5];
        for (int i = 0; i < this.cinemas.size(); i++){
            String[] cur_movie = this.cinemas.get(i).find_close();
            if (good_movie[1] == null ||
                    Integer.parseInt(good_movie[1].substring(0, 2)) > Integer.parseInt(cur_movie[1].substring(0, 2)) ||
                    Integer.parseInt(good_movie[1].substring(0, 2)) == Integer.parseInt(cur_movie[1].substring(0, 2)) &&
                    Integer.parseInt(good_movie[1].substring(3)) > Integer.parseInt(cur_movie[1].substring(3))){
                good_movie[0] = cur_movie[0];
                good_movie[1] = cur_movie[1];
                good_movie[2] = cur_movie[2];
                good_movie[3] = cur_movie[3];
                good_movie[4] = this.cinemas.get(i).toString();
            }
        }
        System.out.println("Ближайший фильм, который вы можете посетить, будет проходить в кинотеатре " + good_movie[4] +
                ", в зале номер " + good_movie[3] + ".\nФильм называется " + good_movie[0] + ", начинается в " + good_movie[1] +
                " и продлится " + good_movie[2] + " минут.");
    }

    public ArrayList<Cinema> get_cinemas(){
        return new ArrayList<>(this.cinemas);
    }
}
