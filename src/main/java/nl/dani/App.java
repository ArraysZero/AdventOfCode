package nl.dani;
import java.util.ArrayList;
import nl.dani.chllg1.Elf;
import nl.dani.chllg1.InputReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        InputReader reader = new InputReader();

        // System.out.println(reader.readFile("input1.txt"));
        ArrayList<Elf> content = reader.readFile("input1.txt");

        System.out.println("content is " + content.size() + " of elves\n");
        int Maxcal = 0;
        for (int i = 0; i < content.size(); i++){
            // System.out.println(content.get(i).getAllCalories());
            if (content.get(i).getAllCalories() > Maxcal){
                Maxcal = content.get(i).getAllCalories();
            }
        }

        System.out.println("challenge 1: " + Maxcal);

        int[] topThree = {0, 0, 0};

        for (int i = 0; i < content.size(); i++) {
            int smallest = 0;

            for (int n = 0; n < 3; n++){
                if (topThree[smallest] > topThree[n]){
                    smallest = n;
                }
            }

            if (content.get(i).getAllCalories() > topThree[smallest]){
                topThree[smallest] = content.get(i).getAllCalories();
            }
        }

        System.out.println("challenge 2: " + (topThree[0] + topThree[1] + topThree[2]));
    }
}
