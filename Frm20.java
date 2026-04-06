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
        super("🎨Paint and Text Studio");

        pan = new NewPanel();
        t = new TextField();

        // -------- File Menu --------
        f = new Menu("File");
        n = new MenuItem("New");
        s = new MenuItem("Save");

        n.addActionListener(this);
        s.addActionListener(this);

        f.add(n);
        f.add(s);

        // -------- Exit Menu --------
        ex = new Menu("Exit");
        no = new MenuItem("No");
        yes = new MenuItem("Yes");

        no.addActionListener(this);
        yes.addActionListener(this);

        ex.add(no);
        ex.add(yes);

        // -------- Mode Menu --------
        mo = new Menu("Mode");

        text = new Menu("Text");   // Menu (not MenuItem)
        paint = new MenuItem("Paint");

        paint.addActionListener(this);

        // -------- Size Submenu --------
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

        text.add(sz);   // add size inside text

        mo.add(text);
        mo.add(paint);

        // -------- MenuBar --------
        m = new MenuBar();
        setMenuBar(m);
        m.add(f);
        m.add(ex);
        m.add(mo);

        // -------- Layout --------
        setLayout(new BorderLayout());

        // Default → Paint
        add(pan, BorderLayout.CENTER);

        // Window close
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

        // -------- TEXT MODE (Size selection) --------
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

        // -------- PAINT MODE --------
        if (b == paint) {
            remove(t);
            add(pan, BorderLayout.CENTER);

            validate();
            repaint();
        }

        // -------- NEW --------
        if (b == n) {
            t.setText("");
            pan.repaint();
        }

        // -------- SAVE --------
        if (b == s) {
            JOptionPane.showMessageDialog(null, "Saved Successfully");
            t.setText("");
            pan.repaint();
        }

        // -------- EXIT --------
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