
import java.awt.*;

public class MyTextArea extends TextArea {

    Mediator med;


    public MyTextArea(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registTextArea(this);
    }

}
