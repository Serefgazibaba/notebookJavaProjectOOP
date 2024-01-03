
import java.awt.*;

public class SaveAsMenuItem extends MenuItem implements Command {

    Mediator med;

    public SaveAsMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;     
        med.registSaveAs(this);
    }

    public void execute() {
        med.saveas();
    }

}
