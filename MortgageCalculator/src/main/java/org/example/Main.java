package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Set the number months in a year and percentage to a constant
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyInterestRate =0;
        int periodsInYears = 0;

        Scanner scanner = new Scanner(System.in);

//        Obtain monthly interest rate by prompting user for input
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

//         Obtain the number of payments (period in years) by prompting user for input
        while (true) {
            System.out.print("Periods (Years): ");
            int period = scanner.nextInt();
            if (period > 1 && period <= 30) {
                periodsInYears = period * MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 1 but less than 30");
        }

//        Obtain the principal
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >=1000 && principal <=1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

//        Calculate the mortgage in $
        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, periodsInYears)) / Math.pow(1 + monthlyInterestRate, periodsInYears) - 1;
        NumberFormat mortgageFormatted = NumberFormat.getCurrencyInstance();
        String value = mortgageFormatted.format(mortgage);
        System.out.println("Mortgage: " + value);

    }
}
