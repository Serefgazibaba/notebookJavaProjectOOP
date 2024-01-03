
import java.awt.*;

public class SaveMenuItem extends MenuItem implements Command {

    Mediator med;

    public SaveMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        med.registSave(this);
    }

    public void execute() {
        med.save();
    }

}
