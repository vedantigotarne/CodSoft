

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxAttempts = 5;
        int randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
        int attempts = 0;
        boolean guessedCorrectly = false;
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                guessedCorrectly = true;
                break;
            } else if (guess < randomNumber) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you did not guess the number. The correct number was " + randomNumber + ".");
        }

        scanner.close();
    }
}


    
    


