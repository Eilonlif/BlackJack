package random_tarigilim.poker;

public class Main {
    public static void main(String[] args) {
        int gameCount = 1000;
        int[][] wins = {{-1, 0}, {1, 0}, {2, 0}};  // {{bType, count}, {bType, wins}, ...},  -1 is for draws...
        for (int i = 0; i < gameCount; i++){
            System.out.println("Game number " + i + "! ");
            Game g = new Game(1);  // Max at 15 Players sometimes work with 15 but you know statistics.
            g.init();                            // As the player number goes higher the percentage of total losses goes lower as expected.
            g.botplay();

            wins(wins, g);
        }
        printWins(wins, gameCount);
    }

    public static int[][] wins(int[][] wins, Game g){
        for (int[] tutWin: wins){
            if(tutWin[0] == g.botTypeWin()){
                tutWin[1]++;
            }
        }
        return wins;
    }

    public static void printWins(int[][] wins, double gameCount){
        for (int[] tutWin: wins){
            if (tutWin[0] == -1){
                System.out.println("Total losses: " + tutWin[1]);
            }
            else {
                System.out.println("Bot type: " + tutWin[0] + ", Number of wins: " + tutWin[1]);
            }
        }
        System.out.println("The percentage of total losses to over-all games is: " + (wins[0][1] / gameCount) * 100 + "% ");
    }
}
