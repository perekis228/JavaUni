package Lab3;
import java.util.ArrayList;
import java.util.Scanner;

public class Ticket_sys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int action;
        Company company = new Company();
        String[] admin = {"admin", "1234"};
        String status = null;

        System.out.println("Добро пожаловать в билетную систему! Выберите действие:");
        while (true){
            if (status == null) {
                System.out.println("1. Войти как гость.");
                System.out.println("2. Войти как админ.");
                System.out.println("3. Выйти.");
                action = scanner.nextInt();

                if (action == 1) {
                    status = "guest";
                    System.out.println("Вы успешно вошли как гость!");
                } else if (action == 2) {
                    scanner.nextLine();
                    System.out.println("Введите логин:");
                    String login = scanner.nextLine();
                    System.out.println("Введите пароль:");
                    String password = scanner.nextLine();
                    if (login.equals(admin[0]) && password.equals(admin[1])) {
                        status = "admin";
                        System.out.println("Вы успешно вошли как админ!");
                    } else {
                        System.out.println("Неверный логин или пароль!");
                    }
                }
                else if (action == 3){
                    break;
                }
                else {
                    System.out.println("Некорректная комманда!");
                }
            }
            else if (status.equals("admin")) {
                System.out.println("1. Выйти.");
                System.out.println("2. Добавить кинотеатр.");
                if (company.get_cinemas().size() > 0) {
                    System.out.println("3. Добавить зал.");
                }
                ArrayList<Cinema> cinemas = company.get_cinemas();
                boolean have_halls = false;
                for (int i = 0; i < cinemas.size(); i++){
                    if (cinemas.get(i).get_halls().size() != 0){
                        have_halls = true;
                        break;
                    }
                }
                if (have_halls){
                    System.out.println("4. Добавить кино.");
                }
                action = scanner.nextInt();

                if (action == 1){
                    status = null;
                }
                else if (action == 2){
                    scanner.nextLine();
                    System.out.println("Введите адрес кинотеатра:");
                    String cinema_adress = scanner.nextLine();
                    company.add_cinema(cinema_adress);
                }
                else if (action == 3 && company.get_cinemas().size() > 0) {
                    System.out.println("Выберите кинотеатр:");
                    for (int i = 0; i < cinemas.size(); i++){
                        System.out.println((i+1) + ". " +cinemas.get(i));
                    }
                    action =  scanner.nextInt();

                    if(action > 0 && action <= cinemas.size()){
                        scanner.nextLine();
                        System.out.println("Введите количество рядов:");
                        int vertical = scanner.nextInt();
                        System.out.println("Введите количество кресел в ряду:");
                        int horizontal = scanner.nextInt();
                        company.add_hall(action-1, horizontal, vertical);
                    }
                }
                else if (action == 4 && have_halls){
                    scanner.nextLine();
                    System.out.println("Выберите кинотеатр:");
                    for (int i = 0; i < cinemas.size(); i++){
                        System.out.println((i+1) + ". " + cinemas.get(i));
                    }
                    int cinema_num = scanner.nextInt()-1;

                    if (cinema_num >= 0 && cinema_num < cinemas.size()) {
                        Cinema cur_cinema = cinemas.get(cinema_num);

                        ArrayList<Hall> halls = cur_cinema.get_halls();
                        System.out.println("Всего залов: " + halls.size());
                        System.out.println("Выберите зал:");
                        int hall_num = scanner.nextInt() - 1;

                        if (hall_num >= 0 && hall_num < halls.size()){
                            scanner.nextLine();
                            System.out.println("Введите название фильма:");
                            String name = scanner.nextLine();
                            System.out.println("Введите время начала фильма:");
                            String start = scanner.nextLine();
                            System.out.println("Введите длительность фильма в минутах:");
                            int duration = scanner.nextInt();
                            company.add_movie(cinema_num, hall_num, name, start, duration);
                        }
                        else {
                            System.out.println("Некорректная комманда!");
                        }
                    }
                    else {
                        System.out.println("Некорректная комманда!");
                    }
                }
                else {
                    System.out.println("Некорректная комманда!");
                }
            }
            else {
                System.out.println("1. Выйти.");
                System.out.println("2. Посмотреть свободные места.");
                System.out.println("3. Найти ближайший фильм.");
                action = scanner.nextInt();

                if (action == 1){
                    status = null;
                }
                else if (action == 2){
                    scanner.nextLine();
                    ArrayList<Cinema> cinemas = company.get_cinemas();
                    System.out.println("Выберите кинотеатр:");
                    for (int i = 0; i < cinemas.size(); i++){
                        System.out.println((i+1) + ". " + cinemas.get(i));
                    }
                    int cinema_num = scanner.nextInt()-1;

                    if (cinema_num >= 0 && cinema_num < cinemas.size()) {
                        Cinema cur_cinema = cinemas.get(cinema_num);

                        ArrayList<Hall> halls = cur_cinema.get_halls();
                        System.out.println("Всего залов: " + halls.size());
                        System.out.println("Выберите зал:");
                        int hall_num = scanner.nextInt() - 1;

                        if (hall_num >= 0 && hall_num < halls.size()){
                            scanner.nextLine();
                            System.out.println("Выберите фильм: ");
                            Hall cur_hall = halls.get(hall_num);
                            cur_hall.show_movies();
                            int movie_num = scanner.nextInt()-1;

                            if (movie_num >= 0 && movie_num < cur_hall.movies_count()){
                                cur_hall.show_seats(movie_num);
                                System.out.println("Выберите ряд: ");
                                int vertical = scanner.nextInt()-1;
                                System.out.println("Выберите место: ");
                                int horizontal = scanner.nextInt()-1;
                                int[] sizes = cur_hall.sizes();

                                if (vertical >= 0 && vertical < sizes[0] && horizontal >= 0 && horizontal < sizes[1]){
                                    company.take_seat(cinema_num, hall_num, movie_num, horizontal, vertical);
                                }
                                else {
                                    System.out.println("Некорректная комманда!");
                                }
                            }
                            else {
                                System.out.println("Некорректная комманда!");
                            }
                        }
                        else {
                            System.out.println("Некорректная комманда!");
                        }
                    }
                    else {
                        System.out.println("Некорректная комманда!");
                    }
                }
                else if(action == 3){
                    company.find_close();
                }
                else {
                    System.out.println("Некорректная комманда!");
                }
            }
        }

        scanner.close();
    }
}
