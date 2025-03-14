package Lab3;
import java.util.ArrayList;
import java.util.Arrays;

public class Hall {
    private int vertical;
    private int horizontal;
    private ArrayList<int[][]> seats = new ArrayList<>();
    private ArrayList<String> movie_name = new ArrayList<>();
    private ArrayList<String> movie_time = new ArrayList<>();
    private ArrayList<Integer> movie_duration = new ArrayList<>();

    public Hall(int horizontal, int vertical){
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public void add_movie(String movie_name, String movie_time, int movie_duration){
        String regex = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";

        // Проверка
        if (movie_time.matches(regex)) {
            this.seats.add(new int[this.vertical][this.horizontal]);
            this.movie_name.add(movie_name);
            this.movie_time.add(movie_time);
            this.movie_duration.add(movie_duration);
        } else {
            System.out.println("Строка НЕ соответствует формату 'HH:mm'");
        }
    }

    public int movies_count(){
        return this.seats.size();
    }

    public int[] sizes(){
        return new int[] {this.vertical, this.horizontal};
    }

    public void show_movies(){
        for (int i = 0; i < this.seats.size(); i++){
            System.out.println(i+1);
            System.out.println("Название: " + this.movie_name.get(i));
            System.out.println("Время начала: " + this.movie_time.get(i));
            System.out.println("Длителльность: " + this.movie_duration.get(i));
            System.out.println("Свободных мест: " + free_seats(i));
            System.out.println();
        }
    }

    private int free_seats(int i){
        return this.horizontal*this.vertical - Arrays.stream(this.seats.get(i)).flatMapToInt(Arrays::stream).sum();
    }

    public void show_seats(int moovie_num){
        int[][] cur_seats = this.seats.get(moovie_num);
        for (int i = 0; i <= this.horizontal; i++) {
            String space = (i+1 < 10)? "  " : " ";
            System.out.print(i + space);
        }
        System.out.println();
        for (int i = 0; i < this.vertical; i++) {
            String space = (i+1 < 10)? "  " : " ";
            System.out.print((i + 1) + space);
            for (int j = 0; j < this.horizontal; j++) {
                System.out.print(cur_seats[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void take_seat(int moovie_num, int horizontal, int vertical){
        if (moovie_num >= 0 && moovie_num < movie_name.size()) {
            int[][] cur_seats = this.seats.get(moovie_num);
            if (horizontal < 0 || horizontal >= this.horizontal || vertical < 0 || vertical >= this.vertical) {
                System.out.println("Место указано некорректно!");
            } else if (cur_seats[vertical][horizontal] == 0) {
                this.seats.get(moovie_num)[vertical][horizontal] = 1;
                System.out.println("Вы успешно забронировали место!");
            } else {
                System.out.println("Место уже занято!");
            }
        }
    }

    public String[] find_close(){
        String[] good_movie = new String[3];
        for (int i = 0; i < this.seats.size(); i++){
            if (good_movie[1] == null ||
                    free_seats(i) > 0 &&
                    (Integer.parseInt(good_movie[1].substring(0, 2)) > Integer.parseInt(this.movie_time.get(i).substring(0, 2)) ||
                    Integer.parseInt(good_movie[1].substring(0, 2)) == Integer.parseInt(this.movie_time.get(i).substring(0, 2)) &&
                    Integer.parseInt(good_movie[1].substring(3)) > Integer.parseInt(this.movie_time.get(i).substring(3)))){
                good_movie[0] = this.movie_name.get(i);
                good_movie[1] = this.movie_time.get(i);
                good_movie[2] = this.movie_duration.get(i).toString();
            }
        }
        return good_movie;
    }
}
