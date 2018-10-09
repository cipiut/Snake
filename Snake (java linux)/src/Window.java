import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{

    public Window(Joc joc,Dimension dimension){
        JFrame frame = new JFrame("Snake");
        frame.setMaximumSize(dimension);
        frame.setPreferredSize(dimension);
        frame.setMinimumSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(joc);
        frame.setVisible(true);
        joc.start();
    }
}