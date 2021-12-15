package Tree.GrapicsTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DrawingFrame extends JFrame {
    DrawingFrame(){
        this.add(new DrawingPanel());
        this.setTitle("Tree");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

class DrawingPanel extends JPanel implements ActionListener {

    DrawingPanel(){
        this.setPreferredSize(new Dimension(1600,900));
        this.setBackground(Color.black);
        this.setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //repaint();
    }


    public void draw(Graphics g, int n, int x, int y, int w, int h){
        if(n==0) return;
        // left
        g.drawLine(x,y,x-w,y-h);

        draw(g,n-1,x-w,y-h,w/2,h+2);
        g.drawLine(x,y,x+w,y-h);
        draw(g,n-1,x+w,y-h,w/2,h+2);
    }

    public void drawStar(Graphics g, int n , int x, int y, int l){
        if(n == 0) return;
        long time = System.currentTimeMillis();
        g.drawLine(x,y,x+l, y);
        drawStar(g,n-1,x+l,y,l/3);

        g.drawLine(x,y,x, y+l);
        drawStar(g,n-1,x,y+l,l/3);

        g.drawLine(x,y,x-l, y);
        drawStar(g,n-1,x-l,y,l/3);

        g.drawLine(x,y,x, y-l);
        drawStar(g,n-1,x,y-l,l/3);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.green);

//        g.translate(700, 350);
//        drawStar(g,5,0,0,200);

        g.translate(700, 600);
        draw(g, 7,0, 0, 250, 75);
    }
}

public class DrawTree{
    public static void main(String[] args) {

        new DrawingFrame();
    }

}
