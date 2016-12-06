import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alex on 06.12.2016.
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("input.txt"));

        while (sc.hasNextLine()) {
            System.out.printf("%s\n", sc.nextLine());
        }

    }
}
