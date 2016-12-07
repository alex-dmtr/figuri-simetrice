import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 07.12.2016.
 */
public class Screen extends JPanel {

    Grid grid;
    public Screen(Grid grid) {
        repaint();

        this.grid = grid;
    }

    public void paint(Graphics g) {

        int cellSize = 20;
        int columns = 8;
        for (int solutionIndex = 0; solutionIndex < grid.solutions.size(); solutionIndex++) {

            int[][] sol = grid.solutions.get(solutionIndex);
            for (int i = 0; i < grid.getRows(); i++)
                for (int j = 0; j < grid.getColumns(); j++) {

                    int offsetX = j * cellSize + solutionIndex % columns * (grid.getColumns() * cellSize + cellSize);
                    int offsetY = i * cellSize + solutionIndex / columns * (grid.getRows() * cellSize + cellSize);

                    if (sol[i][j] == 0) {
                        g.setColor(Color.black);
                        g.drawRect(offsetX, offsetY, cellSize, cellSize);
                    }
                    else if (sol[i][j] == 1) {
                        g.setColor(Color.red);
                        g.fillRect(offsetX, offsetY, cellSize, cellSize);

                    }

                    else if (sol[i][j] == -1) {
                        g.setColor(Color.black);
                        g.fillRect(offsetX, offsetY, cellSize, cellSize);
                    }
                        //                    g.drawRect(0 + cellSize * i, 0 + 50 * j, 50, 50);
                }
        }
    }
}
