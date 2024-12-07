import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Lab1RomaniukKI304 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid size value entered.");
            return;
        }

        System.out.print("Enter a placeholder character: ");
        String input = scanner.nextLine();
        if (input.length() != 1) {
            System.out.println("Error: entered incorrect symbol");
            return;
        }
        char filler = input.charAt(0);

        char[][] jaggedArray = new char[n / 2 + 1][];
        for (int i = 0; i <= n / 2; i++) {
            jaggedArray[i] = new char[n - 2 * i];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = filler;
            }
        }

        printJaggedArray(jaggedArray);

        try {
            saveToFile(jaggedArray, "output.txt");
            System.out.println("The array is successfully saved to a file output.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void printJaggedArray(char[][] jaggedArray) {
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void saveToFile(char[][] jaggedArray, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                writer.write(jaggedArray[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.close();
    }
}
