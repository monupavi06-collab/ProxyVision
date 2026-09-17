package org.example;

public class DecisionEngine {

    public static String decide(String text) {

        text = text.toLowerCase();

        if (text.contains("please select a transaction")) {
            return "You are on the Transaction Menu. Please choose an option.";
        }

        if (text.contains("withdraw")) {
            return "Press Withdraw Cash.";
        }

        if (text.contains("balance")) {
            return "Press Balance Enquiry.";
        }

        if (text.contains("mini statement")) {
            return "Press Mini Statement.";
        }

        if (text.contains("enter your pin") || text.contains("4-digit pin")) {
            return "Please enter your 4-digit PIN.";
        }

        if (text.contains("select amount")) {
            return "Please select the withdrawal amount.";
        }

        if (text.contains("collect your cash")) {
            return "Please collect your cash.";
        }

        if (text.contains("collect your card")) {
            return "Please collect your ATM card.";
        }

        if (text.contains("transaction successful")) {
            return "Transaction completed successfully.";
        }
        if (text.contains("select a transaction") ||
                text.contains("transaction menu")) {
            return "You are on the transaction menu. Please choose an option.";
        }

        if (text.contains("cash withdrawal")) {
            return "Please select cash withdrawal.";
        }

        if (text.contains("balance enquiry") ||
                text.contains("balance inquiry")) {
            return "Please select balance enquiry.";
        }

        if (text.contains("cancel")) {
            return "Cancel option is available.";
        }

        if (text.contains("thank you")) {
            return "Thank you for banking with us.";
        }

        return "Screen not recognized.";

    }
    public static void main(String[] args) {

        String testText = "welcome to xyz bank please select a transaction";

        String result = decide(testText);

        System.out.println("Test Text: " + testText);
        System.out.println("Instruction: " + result);
    }
}