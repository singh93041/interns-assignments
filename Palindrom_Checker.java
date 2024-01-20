package org.fi;


import java.util.Scanner;

public class Palindrom_Checker {

    public static void main(String[] args) {
        // Declare variables
        String str, rev = "";
        int i;

        // Create a Scanner object for user input
        Scanner Sc = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter Any String");

        // Read the entered string from the user
        str = Sc.nextLine();

        // Convert the string to lowercase for case-insensitive palindrome check
        str = str.toLowerCase();

        // Reverse the string
        for (i = str.length() - 1; i >= 0; i--)
            rev += str.charAt(i);

        // Check if the reversed string is equal to the original string
        if (str.equals(rev))
            // Print the result if it is a palindrome
            System.out.println("String Is Palindrome");
        else
            // Print the result if it is not a palindrome
            System.out.println("String Is Not Palindrome");
    }
}
