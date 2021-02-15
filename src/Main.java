import javax.swing.*;
import java.awt.*;
import java.util.zip.CheckedInputStream;

public class Main extends JFrame {
    JFrame jFrame;
    AppPanel appPanel;
    int width=1000, height=width*9/12;
    public static void main(String arg[]) {
        new Main();

    }

    public Main() {
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(width,height));

        appPanel = new AppPanel();
        jFrame.add(appPanel);



    }
}
