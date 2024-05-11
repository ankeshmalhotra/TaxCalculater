package SnippetsQuestion;

import java.util.Scanner;

import java.util.Scanner;

class SnippetsQuestion {
    // Define tax brackets and rates
    private static final double[] TAX_BRACKETS = {500000, 1000000, 1500000};
    private static final double[] TAX_RATES = {0.1, 0.2, 0.3};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your monthly salary: ");
        double monthlySalary = scanner.nextDouble();

        double annualSalary = monthlySalary * 12;

        double tax = calculateIncomeTax(annualSalary);

        double taxPercentage = (tax / annualSalary) * 100;

        System.out.println("Annual Salary: $" + annualSalary);
        System.out.println("Income Tax Paid: $" + tax);
        System.out.println("Income Tax Percentage: " + taxPercentage + "%");

        scanner.close();
    }

    private static double calculateIncomeTax(double income) {
        double tax = 0;
        double taxableIncome = income;

        // Calculate tax based on tax brackets
        for (int i = 0; i < TAX_BRACKETS.length; i++) {
            if (taxableIncome <= 0) {
                break;
            }
            double bracket = TAX_BRACKETS[i];
            double rate = TAX_RATES[i];
            if (taxableIncome <= bracket) {
                tax += taxableIncome * rate;
                break;
            } else {
                tax += bracket * rate;
                taxableIncome -= bracket;
            }
        }

        return tax;
    }
}
