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

public class InteractWithUser implements Constants{
    private Scanner userEntry;

    public InteractWithUser() {
        this.userEntry = new Scanner(System.in);
    }

    public String readFileFromUser() {
        Charset charset = StandardCharsets.UTF_8;

        while (!validEntry) {
            try {
                System.out.print("Enter input file name: ");
                String filename = "./" + getKeyboardString();
                Path filepath = Paths.get(filename);
                List<String> lines = Files.readAllLines(filepath, charset);
                return lines.get(0);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Not a valid filename. Please try again.");
            }
        }
    }

    public int getOneIntFromUser(String display) {
        while (!validEntry) {
            try {
                System.out.print(display);
                int searchKey = getKeyboardInteger();
                System.out.println();
                return searchKey;
            } catch (Exception e) {
                System.out.println("Not a valid search key. Please try again.");
            }
        }
    }

    public String getKeyboardString() {
        if(this.userEntry.hasNext()) return this.userEntry.next();
        else return "";
    }

    public int getKeyboardInteger(){
        if(this.userEntry.hasNextInt())
            return this.userEntry.nextInt();
        else
            return 0;
    }

    public double getKeyboardDouble(){
        if(this.userEntry.hasNextDouble())
            return this.userEntry.nextDouble();
        else
            return 0.0;
    }

    public void fillArr(String[] arr, String display) {
        int counter = 0;
        try {
            System.out.println(display);
            while (counter < arr.length) {
                String userStr = getKeyboardString();
                arr[counter] = userStr;
                counter ++;
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Not a valid input.");
        }
    }
    public void printArrNoSpaces(String[] arr, String display){
        System.out.println(display);
        for (String a: arr) System.out.print(a + " ");
        System.out.println("\n");
    }
}
