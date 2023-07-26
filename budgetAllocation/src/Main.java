import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> proportions = new ArrayList();
        int index = 0;
        double budget, proportionsSum = 0;

        // Get The Budget From The User:
        while (true) {
            System.out.print("Enter your budget: ");
            budget = scanner.nextDouble();

            if (budget > 0) {
                break;
            } else {
                System.out.println("The budget should be more than 0.00$");
            }
        }

        // Get Proportion From The User:
        while (true) {
            double proportion = 0;

            System.out.print("Enter a proportion: ");
            proportion = scanner.nextDouble();

            if (proportion < 0 ) {
                System.out.println("\tOnly Positive Numbers !");
                continue;
            };

            if ((proportionsSum + proportion) <= 100) {
                proportions.add(proportion);
                proportionsSum += proportion;
            } else {
                System.out.println("The next proportions shouldn't be more than " + (100 - proportionsSum) + "%");
            }

            if (proportionsSum == 100) {
                proportions.trimToSize(); // Trims the capacity of this ArrayList instance to be the list's current size
                break;
            };
        }

        // Find The Amount Of Each Item:
        final int ARRAY_SIZE = proportions.size(); // In order to not reCall it on every iteration
        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.println(
                    "\n\tItem " + (i + 1) + ": "
                    + "Proportion: " + decimalFormat.format(proportions.get(i)) + "%"
                    + " -- "
                    + "Amount: " + decimalFormat.format((budget * proportions.get(i)) / 100) + "$"
            );
        }
    }
}















