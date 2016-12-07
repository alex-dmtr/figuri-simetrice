import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alex on 07.12.2016.
 */
public class Grid {
    private  ArrayList<Point> points;
    private  int[][] a;
    private  int n, m;

    private int fillPoints(Point start, int color ) {
        ArrayList<Point> queue = new ArrayList<>();

        int totalPoints = 0;

        queue.add(start);
        a[start.lin][start.col] = 2 * color;
        while (queue.size() > 0) {
            Point current = queue.get(0);
            queue.remove(0);

            totalPoints++;

            for (Point neighbor : current.getNeighbors())
                if (0 <= neighbor.lin && neighbor.lin < n && 0 <= neighbor.col && neighbor.col < m) {
                    if (a[neighbor.lin][neighbor.col] == color) {
                        queue.add(neighbor);

                        a[neighbor.lin][neighbor.col] = 2 * color;
                    }
                }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == 2 * color)
                    a[i][j] = color;

        return totalPoints;
    }
    private  void checkContinuity() throws Exception {
        int totalPoints = 0;

        for (Point p: points)
            if (a[p.lin][p.col] == 1) {
                totalPoints += fillPoints(p, 1);
                break;
            }

        for (Point p: points)
            if (a[p.lin][p.col] == -1) {
                totalPoints += fillPoints(p, -1);
                break;
            }

        if (totalPoints != points.size())
            throw new Exception("Areas not continuous");

    }
    private  void check() throws Exception {

        // check area
        int area = 0;
        for (Point p : points)
            area += a[p.lin][p.col];

        if (area != 0)
            throw new Exception("Areas not equal");

        // check continuous areas
        checkContinuity();
//        if (points.size() > 2)
//            for (int i = 0; i < n-1; i++)
//                for (int j = 0; j < m-1; j++)
//                    if (!(a[i][j] * a[i][j+1] > 0 || a[i][j] * a[i+1][j] > 0))
//                        throw new Exception("Areas not continuous");

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

        // both horizontal and vertical symmetry
        boolean turnOverOk = true;
        for (Point p: points)
            if (a[p.lin][p.col] * a[n-1-p.lin][m-1-p.col] > 0) {
                turnOverOk = false;
                break;
            }
        if (!(horizOk || verticalOk || turnOverOk))
            throw new Exception("No symmetry");


    }

    public ArrayList<int[][]> solutions = new ArrayList<>();

    private boolean solutionsMirrored(int[][] x, int[][] y) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (x[i][j] != y[i][j] * (-1))
                    return false;
        return true;
    }
    private void show() {
        for (int[][] sol: solutions)
            if (solutionsMirrored(a, sol))
                return;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++)
                System.out.printf("%2d ", a[i][j]);
            System.out.printf("\n");
        }

        System.out.printf("\n");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = a[i][j];

        solutions.add(matrix);
    }
    private  void back(int k) {
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

    public Grid(String fileName) throws FileNotFoundException {
        this.readFromFile(fileName);
    }

    public int getRows() {
        return n;
    }

    public int getColumns() {
        return m;
    }

    private void readFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

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
