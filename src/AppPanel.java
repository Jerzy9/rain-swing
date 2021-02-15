import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppPanel extends JPanel implements Runnable {
    JPanel jPanel;
    Thread thread;
    Random r = new Random();

    List<Line> rain;
    Line line;

    int width = 1000,height=width*9/12;
    int ticks = 0;
    int x1 = 0,y1 = 0,x2,y2,length;

    boolean running = false;

    public AppPanel() {
        jPanel = new JPanel();
        add(jPanel);
        rain = new ArrayList<Line>();
        rain.size();

        start();
    }
    public void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public void stop() {

    }
    public void tick() {
        if(ticks>100000) {
            //rain creator
            if(rain.size()<120) {
                x1 = r.nextInt(width);
                y1 = -200;
                x2 = x1;
                y2 = y1+((r.nextInt(4)+2)*30);
                //System.out.println(y2);

                line = new Line(x1, y1, x2, y2);
                rain.add(line);
            }
            //rain falling
            for (int i = 0; i <rain.size(); i++) {

                rain.get(i).y1 += rain.get(i).gravity/6;
                rain.get(i).y2 += rain.get(i).gravity/6;


                rain.get(i).gravity++;
                //lines teleporting from down to up
                if (rain.get(i).y2>900) {

                    rain.get(i).y1= -200;
                    rain.get(i).y2 = y1+((r.nextInt(4)+2)*30);
                    rain.get(i).gravity=0;
                }
            }
            ticks=0;
        }
        ticks++;
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,width,height);

        for (int i = 0; i <rain.size(); i++) {
            rain.get(i).drawLine(g);
        }
    }
    @Override
    public void run() {
        while(running) {
            repaint();
            tick();
        }
    }
}
