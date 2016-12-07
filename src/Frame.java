import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 07.12.2016.
 */
public class Frame extends JFrame {

    Screen s;

    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);
        setResizable(false);
        setTitle("Graphics");

        init();
    }

    public void init() {
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1, 0, 0 ));

        s = new Screen();
        add(s);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
