import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 07.12.2016.
 */
public class Screen extends JPanel {
    public Screen() {
        repaint();
    }

    public void paint(Graphics g) {
        g.drawRect(100, 100, 50, 50);
    }
}
