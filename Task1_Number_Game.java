import java.util.Scanner;
import java.util.Random;

public class Task1_Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;
        
        while (playAgain) {
            int min = 1;
            int max = 100;
            int attempts = 0;
            int randomNumber = random.nextInt(max - min + 1) + min;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a unique number between 1 and 100. Try to guess it!");

            while (!guessedCorrectly && attempts < 5) { // Limiting attempts to 5 per round
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Average number of attempts per round: " + (double) totalAttempts / rounds);
        
        scanner.close();
    }
}
