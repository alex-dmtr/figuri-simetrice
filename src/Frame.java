import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 07.12.2016.
 */
public class Frame extends JFrame {

    Screen s;

    public Frame(Grid grid) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1280, 720);
        setResizable(false);
        setTitle("Graphics");

        init(grid);
    }

    public void init(Grid grid) {
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1, 0, 0 ));

        s = new Screen(grid);
        add(s);

        setVisible(true);
    }
//
//    public static void main(String[] args) {
//        new Frame();
//    }
}
