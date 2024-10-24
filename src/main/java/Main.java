import java.util.Scanner;

// NOTE: I wrote this code using ChatGPT, as this is an exercise in Github Actions, not in Java

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Welcome to the Interactive Calculator!");
        System.out.println("Available commands: add, subtract, multiply, divide, fibonacci, binary, exit");
        System.out.println("Type your command followed by the required parameters.");
        System.out.println("For example: add 5 3");
        System.out.println("Type 'exit' to quit the program.\n");

        while (true) {
            System.out.print("> "); // Prompt symbol
            String input = scanner.nextLine().trim();

            // Check for empty input
            if (input.isEmpty()) {
                continue; // Skip to the next iteration
            }

            // Split the input into command and arguments
            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            // Exit condition
            if (command.equals("exit")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            try {
                switch (command) {
                    case "add":
                        if (parts.length != 3) {
                            System.out.println("Usage: add <int a> <int b>");
                            break;
                        }
                        int addA = Integer.parseInt(parts[1]);
                        int addB = Integer.parseInt(parts[2]);
                        int addResult = calculator.add(addA, addB);
                        System.out.println("Result: " + addResult);
                        break;

                    case "subtract":
                        if (parts.length != 3) {
                            System.out.println("Usage: subtract <int a> <int b>");
                            break;
                        }
                        int subA = Integer.parseInt(parts[1]);
                        int subB = Integer.parseInt(parts[2]);
                        int subResult = calculator.subtract(subA, subB);
                        System.out.println("Result: " + subResult);
                        break;

                    case "multiply":
                        if (parts.length != 3) {
                            System.out.println("Usage: multiply <int a> <int b>");
                            break;
                        }
                        int mulA = Integer.parseInt(parts[1]);
                        int mulB = Integer.parseInt(parts[2]);
                        int mulResult = calculator.multiply(mulA, mulB);
                        System.out.println("Result: " + mulResult);
                        break;

                    case "divide":
                        if (parts.length != 3) {
                            System.out.println("Usage: divide <int a> <int b>");
                            break;
                        }
                        int divA = Integer.parseInt(parts[1]);
                        int divB = Integer.parseInt(parts[2]);
                        if (divB == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                            break;
                        }
                        int divResult = calculator.divide(divA, divB);
                        System.out.println("Result: " + divResult);
                        break;

                    case "fibonacci":
                        if (parts.length != 2) {
                            System.out.println("Usage: fibonacci <int n>");
                            break;
                        }
                        int n = Integer.parseInt(parts[1]);
                        int fibResult = calculator.fibonacciNumberFinder(n);
                        System.out.println("Fibonacci number F(" + n + "): " + fibResult);
                        break;

                    case "binary":
                        if (parts.length != 2) {
                            System.out.println("Usage: binary <int number>");
                            break;
                        }
                        int number = Integer.parseInt(parts[1]);
                        String binaryResult = calculator.intToBinaryNumber(number);
                        System.out.println("Binary of " + number + ": " + binaryResult);
                        break;

                    default:
                        System.out.println("Unknown command. Available commands: add, subtract, multiply, divide, fibonacci, binary, exit.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please ensure all numerical inputs are valid integers.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
