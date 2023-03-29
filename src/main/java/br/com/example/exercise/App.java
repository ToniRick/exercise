package br.com.example.exercise;

import java.io.IOException;
import java.util.Scanner;
import br.com.example.exercise.solution.Response;

public class App
{

    public static void main( String[] args ) throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a Integer Number:");
        int number = 0;
        boolean waitInput = true;
        try{
            if(args.length > 0){
                number = Integer.parseInt(args[0]);
                waitInput = false;
            }
        } catch (Exception err) {
            number = 0;
        }
        try{
            if (waitInput) {
                number = myObj.nextInt();
            }

            if (number == 0) {
                System.out.println("No entries were provided.");
                number = 100;
            }

            System.out.println("Start of exercise 1.");

            System.out.println("The value " + number + " will be considered for the next steps.");

            for (int i = 1; i <= number; i++) {
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
