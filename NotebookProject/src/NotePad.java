
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NotePad implements ActionListener,KeyListener {

    private static NotePad NotePad;
    private Menu file;
    private Menu edit;
    
    private MenuItem _new;
    private MenuItem open;
    private MenuItem save;
    private MenuItem saveas;
    private MenuItem exit;
    
    private MenuItem undo;
    private MenuItem find;
    
    private MenuBar bar;

    private MyTextArea text;
    private MyFrame frame;
    private Mediator med;

    private Stack textStack;



    public String copyUndoText;

    private NotePad() {
        med = new Mediator();

        textStack = new Stack();


        text = new MyTextArea(med, "TextArea");
        frame = new MyFrame(med, "NotePad");

        file = new Menu("File");
        edit = new Menu("Edit");

        _new = new NewMenuItem(med, "New");
        open = new OpenMenuItem(med, "Open");
        save = new SaveMenuItem(med, "Save");
        saveas = new SaveAsMenuItem(med, "Save as");
        exit = new ExitMenuItem(med, "Exit");
        
        undo = new UndoMenuItem(med, "Undo");
        find = new FindMenuItem(med, "Find");
        
        bar = new MenuBar();

        file.add(_new);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);
        
        edit.add(undo);
        edit.add(find);
        
        bar.add(file);
        bar.add(edit);

        frame.setMenuBar(bar);
        frame.add(text);
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        
        int width = 500;
        int height = 500;
        
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        frame.setVisible(true);

        addListener();

    }

    public static NotePad getInstance(){
        if(NotePad == null){
            NotePad = new NotePad();
        }
        return NotePad;
    }

    public void addListener() {
        _new.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        exit.addActionListener(this);
        
        undo.addActionListener(this);
        find.addActionListener(this);
        text.addKeyListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Command com = (Command) e.getSource();

        if(command == "Undo" && textStack.isEmpty() == false){
            med.copyText = textStack.pop();
        }

        com.execute();



    }







    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != 32 && e.getKeyCode() != 10) {
            this.copyUndoText = text.getText();
            if (textStack.size() < 10) {
                textStack.push(copyUndoText);
            } else {
                textStack.removeFirstItem();
                textStack.push(copyUndoText);
            }
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
