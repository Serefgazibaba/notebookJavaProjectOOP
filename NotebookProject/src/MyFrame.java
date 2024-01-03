
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    Mediator med;

    public MyFrame(Mediator med, String s) {
        super(s);
        this.med = med;
     
        med.registFrame(this);
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );


    }

}
