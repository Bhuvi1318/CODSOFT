package codsoft;

import java.util.Scanner;
import java.util.Random;

public class numbergame {
    private static final int MAX_ATTEMPTS = 4;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 0;

        while (playAgain) {
            round++;
            int attempts = 0;
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            boolean guessedCorrectly = false;

            System.out.println("Round " + round + "\nGuess the number between " + RANGE_START + " and " + RANGE_END);

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + "\nEnter your guess number: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    totalScore += MAX_ATTEMPTS - attempts + 1; // More points for fewer attempts
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too small. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? Type (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your total score after " + round + " rounds is: " + totalScore);
        scanner.close();
    }
}
