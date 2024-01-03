
import java.awt.*;

public class UndoMenuItem extends MenuItem implements Command {

    Mediator med;

    public UndoMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registUndo(this);
    }

    public void execute() {
        med.undo();
    }

}
