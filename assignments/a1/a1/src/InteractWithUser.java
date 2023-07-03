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

public class InteractWithUser {
    private Scanner userEntry;
    private boolean validEntry;

    public InteractWithUser() {
        this.userEntry = new Scanner(System.in);
        this.validEntry = false;
    }

    public String getFilenameFromUser() {
        Charset charset = StandardCharsets.UTF_8;

        while (!this.validEntry) {
            try {
//                System.out.print("Enter input file name: ");
//                String filename = userEntry.nextLine();
                String filename = "test.txt";
                Path filepath = Paths.get(filename);
                List<String> lines = Files.readAllLines(filepath, charset);
                return lines.get(0);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Not a valid filename. Please try again.");
            }
        }

        return "Valid filename not entered.";
    }

    public int getSearchKeyFromUser() {
        while (!this.validEntry) {
            try {
//                System.out.print("Enter search key: ");
//                int searchKey = userEntry.nextInt();
                int searchKey = 37;
                return searchKey;
            } catch (Exception e) {
                System.out.println("Not a valid search key. Please try again.");
            }
        }

        return -1;
    }
}
