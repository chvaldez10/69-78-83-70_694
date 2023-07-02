/**
 * @author Christian Valdez
 */

import  java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextAnalysis {
    public static void main(String[] args) {
        String output = askUserForTextFile();
        System.out.println(output);
    }

    private static String askUserForTextFile() {
        boolean validEntry = false;
        Scanner userEntry = new Scanner(System.in);
        Charset charset = StandardCharsets.UTF_8;

        while (!validEntry) {
            try {
//                System.out.print("Enter input file name: ");
//                String filename = userEntry.nextLine();
                String filename = "test.txt";
                Path filepath = Paths.get(filename);
                List<String> lines = Files.readAllLines(filepath, charset);
                validEntry = true;
                return lines.get(0);
            } catch (Exception e) {
                System.out.println("Not a valid filename. Please try again.");
            }
        }

        return "";
    }

    private static String askUserForSearchKey() {
        boolean validEntry = false;
        Scanner userEntry = new Scanner(System.in);

        while (!validEntry) {
            try {
//                System.out.print("Enter search key: ");
//                String searchKey = userEntry.nextLine();
                String searchKey = "37";
                validEntry = true;
                return searchKey;
            } catch (Exception e) {
                System.out.println("Not a valid filename. Please try again.");
            }
        }

        return "";
    }
}