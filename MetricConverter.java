import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the unit converter!");
        System.out.println("Please input your query. For example, 1 km = mile.");
        System.out.println("Enter 'exit' to exit the program.");

        while (true) {
            System.out.print("Enter your query: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 4) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }

            double value;
            try {
                value = Double.parseDouble(parts[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric value. Please try again.");
                continue;
            }

            String fromUnit = parts[1].toLowerCase();
            String toUnit = parts[3].toLowerCase();

            double result = convert(value, fromUnit, toUnit);

            if (Double.isNaN(result)) {
                System.out.println("Conversion not supported. Please try again.");
            } else {
                System.out.println(value + " " + fromUnit + " = " + result + " " + toUnit);
            }
        }

        scanner.close();
    }

    private static double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit) {
            case "kg":
                return value * 2.20462;
            case "gram":
                return value * 0.03527396;
            case "km":
                return value * 0.621371;
            case "mm":
                return value * 0.0393701;
            case "celsius":
                return (value * 9/5) + 32;
            case "fahrenheit":
                return (value - 32) * 5/9;
            default:
                return Double.NaN;
        }
    }
}