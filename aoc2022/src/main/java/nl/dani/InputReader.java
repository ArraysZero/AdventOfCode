package nl.dani;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import nl.dani.chllg1.Elf;


public class InputReader {
    public InputReader(){}

    public ArrayList<Elf> readCalories(String fileName){
        try {
            return getFileContent(getFileAsIOStream(fileName));
        } catch (IOException e){
            return new ArrayList();
        }
    }

    public ArrayList<String> readGames(String fileName){
        return getLines(getFileAsIOStream(fileName));
    }
    
    public String[] readLines(String fileName) {
        return getLines(getFileAsIOStream(fileName)).toArray(new String[0]);
        
        // for (int i = 0; i < lines.size(); i++) {
        //     // do something
        // }
        
        // return null;
    }

    private InputStream getFileAsIOStream(final String fileName) 
    {
        InputStream ioStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream(fileName);
        
        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private ArrayList<String> getLines(InputStream is) {
        ArrayList<String> games = new ArrayList();

        try (InputStreamReader isr = new InputStreamReader(is); 
                BufferedReader br = new BufferedReader(isr);) {
            String line;
            while ((line = br.readLine()) != null) {
                games.add(line);
            }

            // return games;
        } catch (IOException e) {
            System.out.println("nope");
        }

        return games;
    }

    private ArrayList<Elf> getFileContent(InputStream is) throws IOException {
        ArrayList<Elf> contents = new ArrayList();
        contents.add(new Elf());
        try (InputStreamReader isr = new InputStreamReader(is); 
                BufferedReader br = new BufferedReader(isr);) {
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                if (line.equals("")){
                    contents.add(new Elf());
                } else {
                    // contents.add((Integer) Integer.parseInt(line));
                    // System.out.println(line);
                    contents.get(contents.size() - 1).addSnack(Integer.parseInt(line));
                    // System.out.println(contents.get(contents.size() - 1).getAllCalories());
                }
            }
            is.close();

            return contents;
        }
    }
}