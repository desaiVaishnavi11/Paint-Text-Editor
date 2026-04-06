package paintpkg;
import java.awt.*;
import java.awt.event.*;
import paintpkg.MyPanel;

public class NewPanel extends MyPanel implements ActionListener{
    Panel pe,ps; 
    Button bso,bsfo,bsr,bsfr,bsl,bfree; 
    Button berase;
    Button bplus, bminus;

    Button bcBLACK,bcBLUE,bcGRAY,bcGREEN,bcRED,bcMAGENTA,bcORANGE,bcYELLOW;
    int shape;
    Color bcr;
    int prevX, prevY;


    public NewPanel(){
        super();
        
        pe=new Panel();
        bso=new Button("Oval");
        bsfo=new Button("fill oval");
        bsr=new Button("Rect");
        bsfr=new Button("fillRect");
        bsl=new Button("line");

bfree = new Button("Free Draw");

berase = new Button("Eraser");

Panel psize = new Panel();
psize.setLayout(new GridLayout(1,2,5,5)); 

bplus = new Button("+");
bminus = new Button("-");

bplus.addActionListener(this);
bminus.addActionListener(this);

psize.add(bplus);
psize.add(bminus);

bso.addActionListener(this);
bsfo.addActionListener(this);
bsr.addActionListener(this);
bsfr.addActionListener(this);
bsl.addActionListener(this);
bfree.addActionListener(this);
berase.addActionListener(this);

pe.setLayout(new GridLayout(8,1,5,5));
pe.add(bso);
pe.add(bsfo);
pe.add(bsr);
pe.add(bsfr);
pe.add(bsl);
pe.add(bfree);
pe.add(berase);
pe.add(psize);



        ps=new Panel();
        bcBLACK=new Button("BLACK");
        bcBLUE=new Button("BLUE");
        bcGRAY=new Button("GRAY");
        bcGREEN=new Button("GREEN");
        bcRED=new Button("RED");
        bcORANGE=new Button("ORANGE");
        bcYELLOW=new Button("YELLOW");
        bcMAGENTA=new Button("MAGENTA");

        bcBLACK.addActionListener(this);
        bcBLUE.addActionListener(this);
        bcGRAY.addActionListener(this);
        bcGREEN.addActionListener(this);
        bcRED.addActionListener(this);
        bcORANGE.addActionListener(this);
        bcYELLOW.addActionListener(this);
        bcMAGENTA.addActionListener(this);

        bcBLACK.setBackground(Color.BLACK);
        bcBLUE.setBackground(Color.BLUE);
        bcGRAY.setBackground(Color.GRAY);
        bcGREEN.setBackground(Color.GREEN);
        bcRED.setBackground(Color.RED);
        bcORANGE.setBackground(Color.ORANGE);
        bcYELLOW.setBackground(Color.YELLOW);
        bcMAGENTA.setBackground(Color.MAGENTA);

        ps.setLayout(new GridLayout(2,4,5,5));

        ps.add(bcBLACK);
        ps.add(bcBLUE);
        ps.add(bcGRAY);
        ps.add(bcGREEN);
        ps.add(bcRED);
        ps.add(bcORANGE);
        ps.add(bcYELLOW);
        ps.add(bcMAGENTA);

        setLayout(new BorderLayout());
        add(pe,BorderLayout.EAST);
        add(ps,BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){
        Button b=(Button)e.getSource();
        if(b==bsr){
            setShape(1);
            isFreeDraw = false;
            isEraser = false;
        }

        if(b==bsfr){
            setShape(2);
            isFreeDraw = false;
            isEraser = false;
        }

        if(b==bso){
            setShape(3);
            isFreeDraw = false;
            isEraser = false;
        }

        if(b==bsfo){
            setShape(4);
            isFreeDraw = false;
            isEraser = false;
        }

         if(b==bsl){
            setShape(5);
            isFreeDraw = false;
            isEraser = false;
        }

        if (b == bfree) {
    isFreeDraw = true;
}

if (b == berase) {
    isFreeDraw = true;
    isEraser = true;
}

if (b == bplus) {
    brushSize += 2; 
}

if (b == bminus) {
    if (brushSize > 2) {
        brushSize -= 2; 
    }
}

        if(b==bcBLACK){
            setColor(Color.BLACK);
        }

        if(b==bcBLUE){
            setColor(Color.BLUE);
        }

        if(b==bcGRAY){
            setColor(Color.GRAY);
        }

        if(b==bcMAGENTA){
            setColor(Color.MAGENTA);
        }

        if(b==bcORANGE){
            setColor(Color.ORANGE);
        }

        if(b==bcRED){
            setColor(Color.RED);
        }

        if(b==bcYELLOW){
            setColor(Color.YELLOW);
        }

        if(b==bcGREEN){
            setColor(Color.GREEN);
        }

    }
}








    
