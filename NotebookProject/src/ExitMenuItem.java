
import java.awt.*;

public class ExitMenuItem extends MenuItem implements Command {

    Mediator med;

    public ExitMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registExit(this);
    }

    public void execute() {
        med.exit();
    }

}
