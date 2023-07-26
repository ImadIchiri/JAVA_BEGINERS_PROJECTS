import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = 1;
        double buyingPrice, closingPrice;

        System.out.print("Enter the buying price per share: ");
        buyingPrice = scanner.nextDouble();

        while (true) {
            System.out.print("Enter the closing price per share (Any negative number to leave!): ");
            closingPrice = scanner.nextDouble();

            if (closingPrice < 0) break;
            calculateEarnings(day, buyingPrice, closingPrice);

            day++;
        }

        scanner.close();
    }

    static void calculateEarnings(int day, double buyingPrice, double closingPrice) {
        double result = closingPrice - buyingPrice;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        if (result > 0) {
            System.out.println("After day " + day + ", you earned " + decimalFormat.format(result) + " per share.");
        } else if (result < 0) {
            System.out.println("After day " + day + ", you lost " + decimalFormat.format(Math.abs(result)) + " per share.");
        } else {
            System.out.println("After day " + day + ", you have no earnings per share.");
        }
    }
}












