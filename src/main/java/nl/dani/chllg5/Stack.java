package nl.dani.chllg5;
import java.util.ArrayList;

public class Stack {
    private ArrayList<Character> crates = new ArrayList();

    public Stack(){}

    public void addCrate(char crate){
        crates.add(crate);
    }

    public char moveCrate(){
        char crate = crates.get(crates.size() - 1);
        crates.remove(crates.size() - 1);

        return crate;
    }

    public char getTopCrate(){
        return crates.get(crates.size() - 1);
    }
}