import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import paintpkg.NewPanel;

class Frm20 extends Frame implements ActionListener {

    MenuBar m;
    Menu f, ex, mo, text;
    MenuItem n, s, no, yes, paint;

    Menu sz;
    MenuItem sma, med, la;

    TextField t;
    NewPanel pan;

    Frm20() {
        super("Paint and Text Studio");

        pan = new NewPanel();
        t = new TextField();

        f = new Menu("File");
        n = new MenuItem("New");
        s = new MenuItem("Save");

        n.addActionListener(this);
        s.addActionListener(this);

        f.add(n);
        f.add(s);

    
        ex = new Menu("Exit");
        no = new MenuItem("No");
        yes = new MenuItem("Yes");

        no.addActionListener(this);
        yes.addActionListener(this);

        ex.add(no);
        ex.add(yes);

    
        mo = new Menu("Mode");

        text = new Menu("Text");   
        paint = new MenuItem("Paint");

        paint.addActionListener(this);

    
        sz = new Menu("Size");

        sma = new MenuItem("Small");
        med = new MenuItem("Medium");
        la = new MenuItem("Large");

        sma.addActionListener(this);
        med.addActionListener(this);
        la.addActionListener(this);

        sz.add(sma);
        sz.add(med);
        sz.add(la);

        text.add(sz);   

        mo.add(text);
        mo.add(paint);

    
        m = new MenuBar();
        setMenuBar(m);
        m.add(f);
        m.add(ex);
        m.add(mo);

    
        setLayout(new BorderLayout());

        
        add(pan, BorderLayout.CENTER);

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(800, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object b = e.getSource();

        
        if (b == sma || b == med || b == la) {

            remove(pan);
            add(t, BorderLayout.CENTER);

            if (b == sma) {
                t.setFont(new Font("Arial", Font.BOLD, 12));
            }

            if (b == med) {
                t.setFont(new Font("Arial", Font.BOLD, 18));
            }

            if (b == la) {
                t.setFont(new Font("Arial", Font.BOLD, 24));
            }

            validate();
            repaint();
        }


        if (b == paint) {
            remove(t);
            add(pan, BorderLayout.CENTER);

            validate();
            repaint();
        }

    
        if (b == n) {
            t.setText("");
            pan.repaint();
        }

    
        if (b == s) {
            JOptionPane.showMessageDialog(null, "Saved Successfully");
            t.setText("");
            pan.repaint();
        }

        
        if (b == yes) {
            System.exit(0);
        }

        if (b == no) {
            JOptionPane.showMessageDialog(null, "Exit Cancelled");
        }
    }

    public static void main(String[] args) {
        new Frm20();
    }
}