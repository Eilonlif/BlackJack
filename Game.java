package random_tarigilim.poker;

import java.util.*;
public class Game {
    private Deck gamedeck;
    List<Bot> bots;

    public static Scanner in = new Scanner(System.in);
    public int players;
    public Game(int NumOfPlayers){ this.players = NumOfPlayers; }
    public void init(){
        this.gamedeck = new Deck();
        this.gamedeck.shuffle();
        this.bots = new ArrayList<Bot>();

        for (int i = 0; i < this.players; i++) {
            addbot(2, i);
        }
    }

    public void addbot(int numberOfBotsTypes, int serialnum){  // Keep attention for the BotMeta n (Let n be a positive whole number...)
        int tmp = (int)(Math.random() * numberOfBotsTypes);
        if(tmp == 0){
            this.bots.add(new BotMeta1(serialnum, 1, false));
        }
        if(tmp == 1){
            this.bots.add(new BotMeta2(serialnum, 2, false));
        }
    }

    public void botplay() {
        for (Bot b: this.bots) {
            b.hand.addCard(this.gamedeck.hit());
            b.hand.addCard(this.gamedeck.hit());
            while (!b.hand.folded){
                if (b.turn()){
                    b.hand.addCard(this.gamedeck.hit());
//                    System.out.println("Bot number: " + b.hand.playerNum + ", Kind: " + b.botKindnum + ", Hit! ");
                    if(b.hand.sum()[0] > 21 && b.hand.sum()[1] > 21){
                        b.hand.folded = true;

                    }
                }
                else {
                    b.hand.folded = true;
                }
            }
//            System.out.println("Bot number: " + b.hand.playerNum + ", Kind: " + b.botKindnum + ", Folded at " + b.hand.sum()[0] + " or " + b.hand.sum()[1] +"! ");
        }
        checkWin();
    }

    public void checkWin(){
        int highest = 0;
        for (Bot b: this.bots) {
            if(b.hand.checkwin()){
                System.out.println("Player: " + b.hand.playerNum + ", BotMeta: " + b.botKindnum + ", HighScore: " + b.hand.sum()[0] + "!\n");
                b.won = true;
                return;
            }
            if(b.hand.sum()[0] > highest && b.hand.sum()[0] < 21){
                highest = b.hand.sum()[0];
            }
            if(b.hand.sum()[1] > highest && b.hand.sum()[1] < 21){
                highest = b.hand.sum()[1];
            }
        }
        for (Bot b: this.bots) {
            if (b.hand.sum()[0] == highest || b.hand.sum()[1] == highest){
                System.out.println("Player: " + b.hand.playerNum + ", BotMeta: " + b.botKindnum + ", HighScore: " + b.hand.sum()[0] + "\n");
                b.won = true;
                return;
            }
        }
    }

    public int botTypeWin(){
        for (Bot b: this.bots) {
//            System.out.println("won: " + b.won + " kind: " + b.botKindnum + ", bot type: " + b.botKindnum);
            if(b.won){
                return b.botKindnum;
            }
        }
        return -1;
    }
}
