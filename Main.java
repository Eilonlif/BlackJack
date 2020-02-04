package random_tarigilim.poker;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int gameCount = 1;
        int check1win = 0;
        int check2win = 0;
        for (int i = 0; i < gameCount; i++){
            Game g = new Game();
            g.init();
            g.botplay();
//            System.out.println(g.botTypeWin());
            if(g.botTypeWin() == 1){
                check1win++;
            }
            else if (g.botTypeWin() == 2){
                check2win++;
            }
        }
        System.out.println("1 wins: " + check1win + ", 2 wins: " + check2win);
    }
}
