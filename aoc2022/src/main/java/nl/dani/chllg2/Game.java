package nl.dani.chllg2;

public class Game {
    private char opponent;
    private char you;

    public Game (char opponent, char you){
        this.opponent = opponent;
        this.you = you;
    }

    public int getScore(){
        int score = 0;
        switch (you){
            case 'Z':
                score += 3;
                break;
            case 'Y':
                score += 2;
                break;
            case 'X':
                score += 1;
                break;
            default:
                break;
        }

        return 0;
    }
}