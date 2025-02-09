import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Lab1 obj = new Lab1();
        //obj.syracuse(111);
        //obj.sum_of_series();
        //obj.treasure();
        //obj.cargo();
        //obj.twice_even();
    }

    public void syracuse(int n) {
        int count = 0;
        int start_n = n;
        while (n != 1){
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n = 3*n+1;
            }
            count++;
        }
        System.out.println("Шагов от " + start_n + " до 1: " + count);
    }

    public void sum_of_series(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кол-во элементов: ");
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (i%2==0) {
                sum += scanner.nextInt();
            }
            else {
                sum -= scanner.nextInt();
            }
        }
        System.out.println("Сумма ряда: " + sum);
        scanner.close();
    }

    public void treasure(){
        int x = 0, y = 0, count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Координата x клада: ");
        int treasure_x = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Координата y клада: ");
        int treasure_y = scanner.nextInt();
        scanner.nextLine();

        String direction;
        int step;

        while (true){
            direction = scanner.nextLine();
            if (direction.equals("стоп")) break;

            step = scanner.nextInt();
            scanner.nextLine();
            switch (direction) {
                case "север":
                    y += step;
                    break;
                case "юг":
                    y -= step;
                    break;
                case "запад":
                    x -= step;
                    break;
                case "восток":
                    x += step;
                    break;
                default:
                    System.out.println("Неверное направление, попробуйте снова!" + direction);
            }
            if (x != treasure_x || y != treasure_y) {
                count += 1;
            }
        }
        System.out.println("Минимальное кол-во указаний карты: " + count);
        scanner.close();
    }

    public void cargo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кол-во дорог: ");
        int roads_count = scanner.nextInt();

        int[] min_hight = new int[roads_count];

        for (int i = 0; i < min_hight.length; i++) {
            min_hight[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < roads_count; i++){
            System.out.print("Кол-во туннелей: ");
            int tunnels = scanner.nextInt();
            for (int j = 0; j < tunnels; j++){
                int tunnel_hight = scanner.nextInt();
                if (tunnel_hight < min_hight[i]) min_hight[i] = tunnel_hight;
            }
        }

        int[] good_tunnel = new int[2];

        for (int i = 0; i < min_hight.length; i++){
            if (min_hight[i] > good_tunnel[1]){
                good_tunnel[0] = i;
                good_tunnel[1] = min_hight[i];
            }
        }

        System.out.println("Подходящий туннель под номером " + (good_tunnel[0]+1) + " имеет высоту " + good_tunnel[1]);

        scanner.close();
    }

    public  void twice_even(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        int sum = 0;
        int prod = 1;
        int remainder = 0;
        for (int i = 1; i <= 3; i++){
            remainder = num % 10;
            num = num/10;
            sum += remainder;
            prod *= remainder;
        }

        if (sum % 2 == 0 && prod % 2 == 0) System.out.print("Число дважды чётное");
        else System.out.print("Число НЕ дважды чётное");
        scanner.close();
    }
}