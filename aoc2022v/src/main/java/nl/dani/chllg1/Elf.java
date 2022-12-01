package nl.dani.chllg1;
import java.util.ArrayList;

public class Elf {
    ArrayList<Integer> calories = new ArrayList();

    public Elf(){

    }

    public void addSnack(int calories){
        this.calories.add((Integer) calories);
    }

    public int getAllCalories(){
        int allcalories = 0;

        for (int i = 0; i < calories.size(); i++){
            allcalories += calories.get(i);
        }

        // System.out.print("here");
        return allcalories;
    }

    public int calories(){
        return calories.size();
    }
}