import java.awt.*;
import java.awt.event.*;

public class MouseEventsDemo extends Frame implements MouseListener, MouseMotionListener{
    String msg = "";
    int mouseX = 0,mouseY = 0;//coordinates of mouse checker
    public MouseEventsDemo(){
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        msg=msg+ " -- click received";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Mouse released";
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Mouse entered";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = " Mouse exited";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*"+"mouse at "+ mouseX + ", "+ mouseY;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        msg = "Moving mouse at "+ e.getX()+", "+ e.getY();
        repaint();
    }
    public void paint(Graphics g){
        g.drawString(msg,mouseX,mouseY);
    }

    public static void main(String[] args) {
        MouseEventsDemo appwin = new MouseEventsDemo();
        appwin.setSize(new Dimension(300,300));
        appwin.setTitle("MouseEventsDemo");
        appwin.setVisible(true);
        appwin.setBackground(Color.getHSBColor(13,28,364));

    }


}
//after pressed close app - it close
class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}
