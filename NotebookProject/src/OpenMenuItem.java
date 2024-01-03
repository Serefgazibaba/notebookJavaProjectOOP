
import java.awt.*;

public class OpenMenuItem extends MenuItem implements Command {

    Mediator med;

    public OpenMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registOpen(this);
    }

    public void execute() {
        med.open();
    }

}
