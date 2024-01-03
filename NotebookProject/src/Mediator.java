
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Mediator {

    MenuItem _new;
    MenuItem open;
    MenuItem save;
    MenuItem saveas;
    MenuItem exit;
    
    MenuItem undo;
    MenuItem find;
    
    Frame frame;
    TextArea text;
    
    String fileName;

    String copyText;

    public void registNew(NewMenuItem menu) {
        _new = menu;
    }
  
    public void registOpen(OpenMenuItem menu) {
        open = menu;
    }

    public void registSave(SaveMenuItem menu) {
        save = menu;
    }
   
    public void registSaveAs(SaveAsMenuItem menu) {
        saveas = menu;
    }
   
    public void registExit(ExitMenuItem menu) {
        exit = menu;
    }
    
    public void registUndo(UndoMenuItem menu) {
		undo = menu;
	}
    
    public void registFind(FindMenuItem menu) {
		find = menu;
	}

    public void registFrame(MyFrame frame) {
        this.frame = frame;
    }
  
    public void registTextArea(MyTextArea text) {
        this.text = text;
    }
   
    public void clean() {
        text.setText(null);
    }
 
    public void open() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.setVisible(true);
        
        fileName = dialog.getFile();
        fileName = dialog.getDirectory() + fileName;
        //System.out.println(fileName);
        
        try  
		{  	
			FileInputStream fis=new FileInputStream(fileName);       
			Scanner sc=new Scanner(fis,"utf-8");
			String fullText = "";
			
			while(sc.hasNextLine())  
			{  
				String line = sc.nextLine();
				fullText = fullText + line + "\n";
			}  
			sc.close();  
			//System.out.println(fullText);
			text.setText(fullText);
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}          
    }
   
    public void save() {
        System.out.println(fileName);
        
        if(fileName == null)
        	saveas();
        else
        {
        	//File existingFile = new File(fileName);
        	try {
				FileWriter writerObj = new FileWriter(fileName, false);
				writerObj.write(text.getText());
	            writerObj.close();
	            
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
        	//buradada direkt fileName in üstüne yaz replace
    }

   
    public void saveas() {
        FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
        dialog.setVisible(true);
        
        fileName = dialog.getFile();
        System.out.println(fileName);
        fileName = dialog.getDirectory() + fileName;
        System.out.println(fileName);

          FileWriter fileCharStream = null;  // File stream for writing file
          try {

             fileCharStream = new FileWriter(fileName);
             // Use file output stream
                fileCharStream.write(text.getText());
                System.out.println(text.getText());
                fileCharStream.close();

          } catch (IOException e) {
        	  e.printStackTrace();
          }
    }

    public void exit() {
        System.exit(0);
    }
    
    public void undo() {
        System.out.println(copyText);
        text.setText(copyText);
    }
    
    public void find() {
        if (fileName == null){
            System.out.println("Arama yapmak için dosyayı kaydediniz!!!");
            save();
        }
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the word to be found");
        String word = sc1.next();
        String oldText = text.getText();

        Scanner sc2 = null;
        try {
            sc2 = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            System.out.println(line);
            if(line.indexOf(word)!=-1) {

                System.out.println(line.indexOf(word));
                System.out.println(text.getText());
                text.setText(text.getText().replaceAll(word,">" +word+"<"));
            }
        }

        Timer t = new Timer( );
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                text.setText(oldText);

            }
        }, 10000);




    }
}


