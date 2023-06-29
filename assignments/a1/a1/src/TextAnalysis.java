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
    }

    private static String askUserForTextFile() {
        boolean validEntry = false;
        Scanner userEntry = new Scanner(System.in);
        Charset charset = StandardCharsets.UTF_8;

        while (!validEntry) {
            try {
                System.out.print("Enter input file name: ");
                String filename = userEntry.nextLine();
                Path filepath = Paths.get(filename);
                List<String> lines = Files.readAllLines(filepath, charset);
                for(String line: lines){
                    System.out.println(line);
                }
                validEntry = true;
                System.out.println("list len = " + lines.toArray().length);
            } catch (Exception e) {
                System.out.println("Not a valid filename. Please try again.");
            }
        }

        return "";
    }
}