
package org.fi;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ArithmeticExpressionSolver {

    public static void main(String[] args) {
        String inputFile = "input.txt";  // Change this to the actual input file path
        String outputFile = "output.txt";  // Change this to the desired output file path

        try {
            solveArithmeticExpressions(inputFile, outputFile);
            System.out.println("Expressions solved successfully. Results written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }

    private static void solveArithmeticExpressions(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String result = solveExpression(line);
                writer.write(line + " = " + result);
                writer.newLine();
            }
        }
    }

    private static String solveExpression(String expression) {
        // Use a stack to evaluate the expression
        Stack<Integer> stack = new Stack<>();
        char[] tokens = expression.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i])) {
                StringBuilder operand = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    operand.append(tokens[i]);
                    i++;
                }
                i--;

                stack.push(Integer.parseInt(operand.toString()));
            } else if (isOperator(tokens[i])) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (tokens[i]) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        return stack.pop().toString();
    }

    private static boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/' || token == '^';
    }
}
