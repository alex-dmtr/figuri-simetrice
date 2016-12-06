import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Alex on 06.12.2016.
 */
public class Test {

    private static ArrayList<Point> points;
    private static int[][] a;
    private static int n, m;

    private static void check() throws Exception {

        // check area
        int area = 0;
        for (Point p : points)
            area += a[p.lin][p.col];

        if (area != 0)
            throw new Exception("Areas not equal");

        // check continuous areas
        if (points.size() > 2)
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < m-1; j++)
                    if (!(a[i][j] * a[i][j+1] > 0 || a[i][j] * a[i+1][j] > 0))
                        throw new Exception("Areas not continuous");

        // check symmetry

        // horizontal symmetry
        boolean horizOk = true;
        for (Point p : points) {
            if (!(a[p.lin][p.col] * a[p.lin][m-1-p.col] < 0)) {
                horizOk = false;
                break;
            }
        }

        // vertical symmetry
        boolean verticalOk = true;
        for (Point p: points) {
            if (!(a[p.lin][p.col] * a[n-1-p.lin][p.col] < 0)) {
                verticalOk = false;
                break;
            }
        }
        if (!(horizOk || verticalOk))
            throw new Exception("No symmetry");


    }

    private static void show() {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++)
                System.out.printf("%d ", a[i][j]);
            System.out.printf("\n");
        }

        System.out.printf("\n");
    }
    private static void back(int k) {
        if (k == points.size()) {
            try {
                check();
                show();
            } catch (Exception e) {
//                System.out.printf("%s\n", e.toString());
            }
        }
        else for (int i = -1; i <= 1; i += 2) {
            a[points.get(k).lin][points.get(k).col] = i;
            back(k+1);
        }

    }
    public static void main(String[] args) throws FileNotFoundException {

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

        back(0);
    }
}
