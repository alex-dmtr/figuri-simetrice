import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Alex on 06.12.2016.
 */
public class Test {

    static ArrayList<Point> points;
    static int[][] a;

    static void back(int k) {
        if (k == points.size())     
    }
    public static void main(String[] args) throws FileNotFoundException {
        int n, m;

        Scanner sc = new Scanner(new File("input.txt"));

        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[n][m];
        points = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();

                if (a[i][j] == 1)
                    points.add(new Point(i, j));
            }




    }
}
