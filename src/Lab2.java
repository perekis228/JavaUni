import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab2 obj = new Lab2();
//task1
//        System.out.print("Введите строку: ");
//        String str = scanner.nextLine();
//        obj.substring(str);

//task2
//        int[] arr1 = {1, 2, 4, 5};
//        int[] arr2 = {3, 4, 6, 7};
//        obj.sum_arr(arr1, arr2);

//task3
//        int[] arr = {1, 2, 3, -4, -5, 2, 7};
//        obj.max_subarr(arr);

//task4
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        obj.turn_arr(arr);

//task5
//        int[] arr = {1, 2, 3, -4, -5, 2, 7};
//        int target = 11;
//        obj.find_num(arr, target);

//task6
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        obj.sum_arr2(arr);

//task7
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        obj.max_in_arr(arr);

//task8
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        obj.turn_arr2(arr);

        scanner.close();
    }

    public void substring(String str){
        String result = "";
        ArrayList<Character> signs = new ArrayList<>();

        for (char ch: str.toCharArray()){
            if (signs.contains(ch)){
                if (result.length() < signs.size()) {
                    result = signs.stream().map(String::valueOf).collect(Collectors.joining());
                }
                signs.clear();
                signs.add(ch);
            }
            else {
                signs.add(ch);
            }
        }

        if (result.length() < signs.size()) {
            result = signs.stream().map(String::valueOf).collect(Collectors.joining());
        }

        System.out.print(result);
    }

    public void sum_arr(int[] arr1, int[] arr2) {
        int[] sum = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, sum, 0, arr1.length);
        System.arraycopy(arr2, 0, sum, arr1.length, arr2.length);

        Arrays.sort(sum);
        System.out.println(Arrays.toString(sum));
    }

    public void max_subarr(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i; j++){
                int sum = Arrays.stream(Arrays.copyOfRange(arr, j, j+i+1)).sum();
                if (sum > max) max = sum;
            }
        }
        System.out.print(max);
    }

    public void turn_arr(int[][] arr){
        int[][] arr2 = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                arr2[j][arr.length - i - 1] = arr[i][j];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }
    }

    public void find_num(int[] arr, int target){
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                num1 = arr[i];
                num2 = arr[j];
                if (num1 + num2 == target) break;
            }
        }
        if (num1 + num2 == target) {
            System.out.print(num1 + ", " + num2);
        }
        else {
            System.out.print("null");
        }
    }

    public void sum_arr2(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += Arrays.stream(arr[i]).sum();
        }
        System.out.print(sum);
    }

    public void max_in_arr(int[][] arr){
        int[] max = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            max[i] = Arrays.stream(arr[i]).max().getAsInt();
        }
        System.out.print(Arrays.toString(max));
    }

    public void turn_arr2(int[][] arr){
        int[][] arr2 = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                arr2[arr.length - j - 1][i] = arr[i][j];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }
    }
}

