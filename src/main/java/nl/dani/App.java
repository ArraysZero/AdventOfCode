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
            int length = rucksacks.get(i).length();
            char[] left = rucksacks.get(i).substring(0, length / 2).toCharArray();
            char[] right = rucksacks.get(i).substring(length / 2).toCharArray();
            
            Arrays.sort(left);
            Arrays.sort(right);

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
                        // break;
                    }
                }
            }
        }

        System.out.println("day 3; challenge 1: " + total);

        total = 0;
        // boolean found = false;
        for (int i = 0; i < rucksacks.size(); i+=3){
            boolean found = false;
            for (int n = 0; n < rucksacks.get(i).length(); n++){
                for (int t = 0; t < rucksacks.get(i+1).length(); t++){
                    for (int e = 0; e < rucksacks.get(i+2).length(); e++){
                        if ((rucksacks.get(i).charAt(n) == rucksacks.get(i+1).charAt(t)) && (rucksacks.get(i).charAt(n) == rucksacks.get(i+2).charAt(e) && !found)){
                            found = true;
                            if (((int) rucksacks.get(i).charAt(n)) >= 97){
                                total += (int) rucksacks.get(i).charAt(n) - 96;
                            } else {
                                total += (int) rucksacks.get(i).charAt(n) - 38;
                            }     
                        }
                    }
                }
            }
        }

        System.out.println("day3: challenge 2: " + total);

        ArrayList<String> ranges = reader.readGames("input4.txt");

        System.out.println(ranges.size());
        int encapsulatingRanges = 0;
        int overlappingPairs = 0;
        for (int i = 0; i < ranges.size(); i++){
            // System.out.println(ranges.get(i));
            String[] range = {ranges.get(i).substring(0, ranges.get(i).indexOf(',')), ranges.get(i).substring(ranges.get(i).indexOf(',') + 1)};
            int[] leftRange = {Integer.valueOf(range[0].substring(0, range[0].indexOf('-'))), Integer.valueOf(range[0].substring(range[0].indexOf('-') + 1))};
            int[] rightRange = {Integer.valueOf(range[1].substring(0, range[1].indexOf('-'))), Integer.valueOf(range[1].substring(range[1].indexOf('-') + 1))};

            System.out.println(range[0] + " " + range[1]);
            if ((leftRange[0] <= rightRange[0] && leftRange[1] >= rightRange[1]) || (leftRange[0] >= rightRange[0] && leftRange[1]<= rightRange[1])) {
                // System.out.println(Integer.valueOf(range[0].substring(0, range[0].indexOf('-'))));
                System.out.println("encapsulates");
                encapsulatingRanges++;
            }

            if ((leftRange[0] <= rightRange[0] && leftRange[1] >= rightRange[0]) || (rightRange[0] <= leftRange[0] && rightRange[1] >= leftRange[0])){
                overlappingPairs++;
            }

            // if (Integer.valueOf(range[0].))
        }

        System.out.println("day4: challenge 1: " + encapsulatingRanges);
        System.out.println("day4: challenge 2: " + overlappingPairs);
    }

    // private int[] getRange (String input){
    //     System.out.println(input.substring(0, input.indexOf('-')));
    //     // return {(int) Integer.valueOf(input.substring(0, input.indexOf('-')))}

    //     return null;
    // }
}
