import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static ArrayList<String> CHOICES = new ArrayList<>(Arrays.asList("Rock", "Paper", "Scissor"));
    static String computerChoice() {
        return CHOICES.get((int) (Math.random() * 2));
    }
    static void showScores (int userScore, int computerScore) {
        System.out.println("You >> " + userScore
                + " - "
                + computerScore + " << Computer");
    }
    public static void main(String[] args) {
        //  Rock Paper Scissor
        Scanner scanner = new Scanner(System.in);
        int usersInput, userScore = 0, computerScore = 0;
        String computerChoiceResult, userChoiceResult;

        System.out.println("WELCOME TO <<Rock Paper Scissor>> GAME !");
        System.out.println("You'll Play Against The Computer !");
        System.out.println("Select The Number Of Your Choice And Beat The Computer (click -1 to exit) !");

        while (true) {
            System.out.println("\n###############\n");
            showScores(userScore, computerScore);
            System.out.println(
                    "(1) Rock \n(2) Paper \n(3)Scissor"
            );
            System.out.print("Choose One (click -1 to exit): ");
            usersInput = scanner.nextInt();

            if (usersInput == -1) {
                System.out.println("See You Later ^_^");
                break;
            }

            if (!Arrays.asList(1, 2,3).contains(usersInput)) {
                System.out.println("Only One Of The Following Numbers: (1 - 2 - 3)");
                continue;
            }

            computerChoiceResult = computerChoice();
            userChoiceResult = CHOICES.get(usersInput - 1);

            System.out.println(
                    "You >> " + userChoiceResult +
                            " - " +
                            computerChoiceResult + " << Computer"
            );

            if (computerChoiceResult.equals(userChoiceResult)) {
                System.out.println("--> DRAW !");
                continue;
            }

            //  Case 1: Computer Choose ROCK
            if (computerChoiceResult.equalsIgnoreCase("rock")) {
                if (userChoiceResult.equalsIgnoreCase("paper")) {
                    System.out.println("--> You Won !");
                    userScore++;
                }

                if (userChoiceResult.equalsIgnoreCase("scissor")) {
                    System.out.println("--> Computer Won !");
                    computerScore++;
                }

                continue;
            }

            //  Case 2: Computer Choose PAPER
            if (computerChoiceResult.equalsIgnoreCase("paper")) {
                if (userChoiceResult.equalsIgnoreCase("rock")) {
                    System.out.println("--> Computer Won !");
                    computerScore++;
                }

                if (userChoiceResult.equalsIgnoreCase("scissor")) {
                    System.out.println("--> You Won !");
                    userScore++;
                }

                continue;
            }

            //  Case 3/ Computer Choose SCISSOR
            if (computerChoiceResult.equalsIgnoreCase("scissor")) {
                if (userChoiceResult.equalsIgnoreCase("rock")) {
                    System.out.println("--> You Won !");
                    userScore++;
                }

                if (userChoiceResult.equalsIgnoreCase("paper")) {
                    System.out.println("--> Computer Won !");
                    computerScore++;
                }
            }
        }
    }
}