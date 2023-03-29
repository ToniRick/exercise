package br.com.example.exercise;

import java.io.IOException;
import java.util.Scanner;
import br.com.example.exercise.solution.Response;

public class App
{

    public static void main( String[] args ) throws IOException {
        System.out.println("Start of exercise 1.");
        Scanner myObj = new Scanner(System.in);
        int number = 0;

        System.out.println("Enter a Integer Number:");
        try{
            number = myObj.nextInt();
            for (int i = 0; i <= number; i++) {
                Response.exercise1(i);
            }
            System.out.println(" ");
            System.out.println("Finished processing the number: " + number);
            System.out.println("End of exercise 1.");
        } catch (Exception err) {
            System.out.println("Processing " + number + " occurred error: " + err);
            System.out.println("End of exercise 1.");
        }
        System.out.println("Start of exercise 2.");
        Response.exercise2();
        System.out.println("End of exercise 2.");
    }
}
