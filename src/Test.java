import java.io.FileNotFoundException;

/**
 * Created by Alex on 06.12.2016.
 */
public class Test {


    public static void main(String[] args) throws FileNotFoundException {
        Grid grid = new Grid("input.txt");

        new Frame(grid);
    }
}
