
import java.awt.*;

public class NewMenuItem extends MenuItem implements Command {

    Mediator med;

    public NewMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registNew(this);
    }

    public void execute() {
        med.clean();
    }

}
