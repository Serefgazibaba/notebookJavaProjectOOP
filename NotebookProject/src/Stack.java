import java.util.ArrayList;

public class Stack {
    ArrayList<String> textList;

    Stack(){
        textList = new ArrayList<>();
    }

    public void push(String e){
        textList.add(e);
    }

    public String pop(){
        int lastItem = textList.size()-1;
        String removedItem = textList.get(lastItem);
        textList.remove(lastItem);
        return removedItem;
    }

    public int size(){
        return textList.size();
    }

    public boolean isEmpty(){
        if(textList.size() > 0){
            return false;
        }else{
            return true;
        }
    }

    public void removeFirstItem(){
        textList.remove(0);
    }
}
