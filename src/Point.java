import java.util.ArrayList;

/**
 * Created by Alex on 06.12.2016.
 */
public class Point {
    public int lin, col;

    public Point(int lin, int col) {
        this.lin = lin;
        this.col = col;
    }

    public Iterable<Point> getNeighbors() {
        ArrayList<Point> neighbors = new ArrayList<>();

        Point[] dir = { new Point(-1, 0), new Point(0, -1), new Point(0, +1), new Point(+1, 0)};

        for (Point d : dir) {
            Point v = this.add(d);

            neighbors.add(v);
        }

        return neighbors;
    }

    public Point add(Point other) {
        return new Point(lin + other.lin, col + other.col);
    }
}
