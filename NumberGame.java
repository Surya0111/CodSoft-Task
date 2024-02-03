import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static int totalWins;

    public static void main(String[] args) {
        System.out.println("*******Number Game*******\n");
        System.out.println("Enter Your Name: \n");

        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();

        System.out.println("Hello " + playerName);

        String userChoice;

        boolean continuePlaying = true;

        totalWins = 0;

        do {
            System.out.println("\n Select your option: \n\n1. Start\n2. Exit\n");

            userChoice = scanner.next();

            switch (userChoice) {
                case "1":
                    playNumberGame(scanner, continuePlaying);

                    System.out.println("\n\nDo you want to play again?: \n\n1. Yes\n2. No\n");
                    String playAgainChoice = scanner.next();

                    while (playAgainChoice.equals("1")) {
                        playNumberGame(scanner, continuePlaying);
                        System.out.println("\n\nDo you want to play again?: \n\n1. Yes\n2. No\n");

                        playAgainChoice = scanner.next();
                    }

                    System.out.println("****Congratulations - You have Won " + totalWins + " Round(s)*****");

                    continuePlaying = false;

                    break;

                case "2":
                    System.out.println("****Didn't make it, Try again*****");
                    continuePlaying = false;
                    break;

                default:
                    System.err.println("Invalid Input, Please Enter Again!");
                    break;
            }

        } while (continuePlaying);

        scanner.close();
    }

    public static void playNumberGame(Scanner scanner, boolean continuePlaying) {
        Random random = new Random();
        int randomValue = random.nextInt(101);
        System.out.println("Let's get started!");

        int chances = 10;
        int userGuess;

        while (chances > 0) {
            System.out.println("\nChances Left: " + chances);
            System.out.println("Please enter Your Guess: ");

            userGuess = scanner.nextInt();

            if (userGuess > randomValue) {
                System.out.println("Enter lesser number!!!\n");
            } else if (userGuess < randomValue) {
                System.out.println("Enter higher number!!!\n");
            } else {
                System.out.println("****Congratulations You Won*****");
                totalWins++;
                continuePlaying = false;
                break;
            }

            chances--;
        }

        if (continuePlaying) {
            System.out.println("\nRandom Value = " + randomValue);
            System.out.println("\n****Game Over, You didn't win this time*****");
            continuePlaying = false;
        }
    }
}
