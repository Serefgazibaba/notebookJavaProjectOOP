
import java.awt.*;

public class FindMenuItem extends MenuItem implements Command {

    Mediator med;

    public FindMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registFind(this);
    }

    public void execute() {
        med.find();
    }

}