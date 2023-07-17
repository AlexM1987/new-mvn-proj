package errors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        try {
            System.out.println("Input first number:");
            a = sc.nextInt();
            System.out.println("Input second number:");
            b = sc.nextInt();
        }catch (InputMismatchException e){
            e.printStackTrace();
            System.err.println("Wrong numbers format.");
            return; // безоговорочный выход из метода main
        }


        try {
            System.out.println(a / b);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("End.");

    }
}
