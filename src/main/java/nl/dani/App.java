package nl.dani;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        ArrayList<Elf> content = reader.readCalories("input1.txt");

        System.out.println("content is " + content.size() + " of elves\n");
        int Maxcal = 0;
        for (int i = 0; i < content.size(); i++){
            // System.out.println(content.get(i).getAllCalories());
            if (content.get(i).getAllCalories() > Maxcal){
                Maxcal = content.get(i).getAllCalories();
            }
        }

        System.out.println("day 1: challenge 1: " + Maxcal);

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

        System.out.println("day 1: challenge 2: " + (topThree[0] + topThree[1] + topThree[2]));

        ArrayList<String> games = reader.readGames("input2.txt");
        HashMap<String, Integer> lookup = new HashMap();
        lookup.put("A X", 4);
        lookup.put("A Y", 8);
        lookup.put("A Z", 3);
        lookup.put("B X", 1);
        lookup.put("B Y", 5);
        lookup.put("B Z", 9);
        lookup.put("C X", 7);
        lookup.put("C Y", 2);
        lookup.put("C Z", 6);

        // System.out.println(games.size());
        int score = 0;
        for (int i = 0; i < games.size(); i++){
            score += lookup.get(games.get(i));
        }

        System.out.println("day 2: challenge 1: " + score);

        HashMap<String, Integer> lookupd = new HashMap();
        lookupd.clear();
        lookupd.put("A X", 3);
        lookupd.put("A Y", 4);
        lookupd.put("A Z", 8);
        lookupd.put("B X", 1);
        lookupd.put("B Y", 5);
        lookupd.put("B Z", 9);
        lookupd.put("C X", 2);
        lookupd.put("C Y", 6);
        lookupd.put("C Z", 7);

        score = 0;
        for (int i = 0; i < games.size(); i++){
            score += lookupd.get(games.get(i));
        }

        System.out.println("day 2: challenge 2: " + score);

        ArrayList<String> rucksacks = reader.readGames("input3.txt");

        System.out.println(((int) 'z') - 96); //char - 96 l of -64 u
        int total = 0;
        for (int i = 0; i < rucksacks.size(); i++){
            // System.out.println(rucksacks.get(i));
            int length = rucksacks.get(i).length();
            char[] left = rucksacks.get(i).substring(0, length / 2).toCharArray();
            char[] right = rucksacks.get(i).substring(length / 2).toCharArray();
            
            Arrays.sort(left);
            Arrays.sort(right);

            // System.out.println(right.length + " " + right.length);
            boolean found = false;
            for (int n = 0; n < left.length; n++){
                for (int t = 0; t < right.length; t++){
                    if (left[n] == right[t] && !found){
                        found = true;
                        if (((int) left[n]) >= 97){
                            total += (int) left[n] - 96;
                        } else {
                            total += (int) left[n] - 38;
                        } 
                        break;
                    }
                }
                // if (left[n] == right[n]){
                //     if (((int) left[n]) >= 97){
                //         total += (int) left[n] - 96;
                //     } else {
                //         total += (int) left[n] - 38;
                //     }
                // }
            }

            // System.out.println(left + " " + right);
        }

        System.out.println("day 3; challenge 1: " + total);
    }
}
