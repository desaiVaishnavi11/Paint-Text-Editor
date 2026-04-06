package paintpkg;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends Panel {
    int x,y,w,h,flg;
    Color cr;
    int shape;
    int prevX, prevY;
boolean isFreeDraw = false;
boolean isEraser = false;
int brushSize = 5;
    public MyPanel(){
        super();
        flg=0;
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(flg==0){
                    x=e.getX();
                    y=e.getY();
                    flg=1;
                }else{

                    if(shape==5){
                        w=e.getX();
                        h=e.getY();
                    }else{

                        w=e.getX()-x;
                         h=e.getY()-y;
                        }
                        draw();
                        flg=0;
                }
            }

            public void mousePressed(MouseEvent e) {
    if (isFreeDraw) {
        prevX = e.getX();
        prevY = e.getY();
    }
}
        });

        addMouseMotionListener(new MouseMotionAdapter() {
    
public void mouseDragged(MouseEvent e) {
    if (isFreeDraw) {
        Graphics g = getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        if (isEraser) {
            g2.setColor(getBackground());
        } else {
            g2.setColor(cr);
        }

        g2.setStroke(new BasicStroke(brushSize));

        int x = e.getX();
        int y = e.getY();

        g2.drawLine(prevX, prevY, x, y);

        prevX = x;
        prevY = y;
    }
}
});

            
    

            
        setSize(400,400);
    }

    public void setColor(Color c){
        cr=c;
    }

    public void setShape(int s){
        shape =s;
    }

    public void draw(){
        Graphics g=getGraphics();
        g.setColor(cr);
        switch(shape){
            case 1:
                g.drawRect(x, y, w, h);break;

            case 2:
                g.fillRect(x, y, w, h);break;

            case 3:
                g.drawOval(x, y, w, h);break;

            case 4:
                g.fillOval(x, y, w, h);break;

            case 5:
                g.drawLine(x, y, w, h);break;
        }
    }

    
}

