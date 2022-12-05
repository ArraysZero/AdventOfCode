package nl.dani.chllg5;

public class CrateStack {
    private Stack[] stacks;

    public CrateStack(int numOfStacks){
        this.stacks = new Stack[numOfStacks];
    }

    public void addStack(int stack, char[] crates){
        // System.out.println("Created");
        stacks[stack] = new Stack();
        for (int i = 0; i < crates.length; i++) {
            this.stacks[stack].addCrate(crates[i]);
        }
    }

    public void moveCrate(int start, int des){
        char crate = stacks[start].moveCrate();
        // stacks[des].addCrate(crate);
        // for (int i = 0; i < crate.length; i++){
            stacks[des].addCrate(crate);
        // }
    }

    public void moveCrates(int start, int des, int num){
        char[] crates = new char[num];
        
        for (int i = 0; i < num; i++){
            crates[i] = stacks[start].moveCrate();
        }

        for (int i = crates.length; i > 0; i--){
            stacks[des].addCrate(crates[i - 1]);
        }
    }

    public String getTopCrates(){
        String result = "";

        for (int i = 0; i < stacks.length;i++){
            result += stacks[i].getTopCrate();
        }

        return result;
    }
}