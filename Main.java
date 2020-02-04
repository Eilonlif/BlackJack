package random_tarigilim.poker;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int gameCount = 5;
        int[][] wins = {{1, 0}, {2, 0}};  // {{bType, count}, {bType, wins}, ...}
        for (int i = 0; i < gameCount; i++){
            System.out.println("Game number " + i + "! ");
            Game g = new Game(15);  // Max at 15 Players sometimes work with 15 but you know statistics...
            g.init();
            g.botplay();

            wins(wins, g);
        }
        printWins(wins);
    }

    public static int[][] wins(int[][] wins, Game g){
        for (int[] tutWin: wins){
            if(tutWin[0] == g.botTypeWin()){
                tutWin[1]++;
            }
        }
        return wins;
    }

    public static void printWins(int[][] wins){
        for (int[] tutWin: wins){
            System.out.println("Bot type: " + tutWin[0] + ", Number of wins: " + tutWin[1]);
        }
    }
}
