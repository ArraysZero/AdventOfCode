package nl.dani.chllg10;

public class CathodeRayTube {

    private String[] instructions;

    public CathodeRayTube(String[] instructions) {
        this.instructions = instructions;
    }
    
    public int sumStrenghtCycle() {
        int sum = 0;
        int eoi = 1;
        int ssc = 20;
        int xRegister = 1;
        int cycle = 0;
        int instruction = 0;
        boolean moreInstructions = true;
        
        if (instructions[instruction].contains("addx")){
            eoi = 3;
        }

        while (moreInstructions) {
            
            if (cycle == eoi) {
                if (instructions[instruction].contains("addx")) {
                    var chg = Integer.parseInt(instructions[instruction].split(" ")[1]);
                    xRegister += chg;
                }
                
                instruction++;
                if (instruction == instructions.length) {
                    moreInstructions = false;
                } else if (instructions[instruction].contains("noop")) {
                    eoi++;
                } else {
                    eoi += 2;
                }
            }

            if (cycle == ssc) {
                sum += (ssc * xRegister);
                ssc += 40;
            }
            
            cycle++;
        }

        return sum;
    }
    
    public String drawScreen() {
        int eoi = 0;
        int xRegister = 1;
        int cycle = 0;
        int instruction = 0;
        String screen = "";
        
        if (instructions[instruction].contains("addx")){
            eoi = 2;
        }

        for (int row  = 0; row < 6; row++) {
            for  (int pos = 0; pos < 40; pos++){
            if (cycle == eoi) {
                if (instructions[instruction].contains("addx")) {
                    var chg = Integer.parseInt(instructions[instruction].split(" ")[1]);
                    xRegister += chg;
                }
                
                instruction++;
                if (instructions[instruction].contains("noop")) {
                    eoi++;
                } else {
                    eoi += 2;
                }
            }
            
            cycle++;
                if (pos - xRegister <= 1 && pos - xRegister >= -1) {
                    screen = screen + "#";
                } else {
                    screen = screen + ".";
                }
            }

            screen = screen + "\n";

        }
        
        // System.out.println(screen);
        return screen;
    }
}