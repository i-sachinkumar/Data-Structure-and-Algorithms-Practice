package NEW.MyGraphics;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyPanel myPanel;
    MyFrame(){
        myPanel = new MyPanel();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics g2D = (Graphics2D) g;
        g2D.drawRect(50, 50, 100, 40);
        //g2D.drawImage(image, 0, 0, null);

        ((Graphics2D) g2D).setPaint(Color.blue);
        ((Graphics2D) g2D).setStroke(new BasicStroke(5));
        g2D.drawLine(0, 0, 500, 500);

        //g2D.setPaint(Color.pink);
        //g2D.drawRect(0, 0, 100, 200);
        //g2D.fillRect(0, 0, 100, 200);

        //g2D.setPaint(Color.orange);
        //g2D.drawOval(0, 0, 100, 100);
        //g2D.fillOval(0, 0, 100, 100);

        //g2D.setPaint(Color.red);
        //g2D.drawArc(0, 0, 100, 100, 0, 180);
        //g2D.fillArc(0, 0, 100, 100, 0, 180);
        //g2D.setPaint(Color.white);
        //g2D.fillArc(0, 0, 100, 100, 180, 180);

        //int[] xPoints = {150,250,350};
        //int[] yPoints = {300,150,300};
        //g2D.setPaint(Color.yellow);
        //g2D.drawPolygon(xPoints, yPoints, 3);
        //g2D.fillPolygon(xPoints, yPoints, 3);

        //g2D.setPaint(Color.magenta);
        //g2D.setFont(new Font("Ink Free",Font.BOLD,50));
        //g2D.drawString("U R A WINNER! :D", 50, 50);
    }
//    public void paint(Graphics g){
//        Graphics g2d = (Graphics2D) g ;
//        g2d.drawLine(50, 50, 100,40);
//    }
}
