package random_tarigilim.poker;

import java.util.*;
public class Game {
    private Deck gamedeck;
    List<Bot> bots;

    public static Scanner in = new Scanner(System.in);
    public void init(){
        int players;
        this.gamedeck = new Deck();
        this.gamedeck.shuffle();
        this.bots = new ArrayList<Bot>();
        players = 10;
        for (int i = 0; i < players; i++) {
            addbot(2, i);
        }
    }

    public void addbot(int numberOfBotsTypes, int serialnum){
        int tmp = (int)(Math.random() * numberOfBotsTypes);
        if(tmp == 0){
            this.bots.add(new BotMeta1(serialnum, 1, false));
        }
        if(tmp == 1){
            this.bots.add(new BotMeta1(serialnum, 2, false));
        }
    }

    public void normailplay(){
        String hitOrMiss;
        for (Bot b: this.bots) {
            b.hand.addCard(this.gamedeck.hit());
            b.hand.addCard(this.gamedeck.hit());
            b.hand.print();
            while (!b.hand.folded){
                System.out.println("The sum is: " + b.hand.sum()[0] + " or " + b.hand.sum()[1]);
                System.out.println("Hit? ");
                hitOrMiss = in.next();
                if (hitOrMiss.equals("y")){
                    b.hand.addCard(this.gamedeck.hit());
                    System.out.println("Bot number: " + b.hand.playerNum + ", Kind: " + b.botKindnum + ", Hit! ");
                    if(b.hand.sum()[0] > 21 && b.hand.sum()[1] > 21){
                        b.hand.folded = true;
                    }
                    else{
                        b.hand.print();
                    }
                }
                else {
                    b.hand.folded = true;
                }
            }
            System.out.println("Bot number: " + b.hand.playerNum + ", Kind: " + b.botKindnum + ", Folded at " + b.hand.sum()[0] + " or " + b.hand.sum()[1] +"! ");
        }
        checkWin();
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
            System.out.println("Bot number: " + b.hand.playerNum + ", Kind: " + b.botKindnum + ", Folded at " + b.hand.sum()[0] + " or " + b.hand.sum()[1] +"! ");
        }
        checkWin();
    }

    public void checkWin(){
        int highest = 0;
        for (Bot h: this.bots) {
            if(h.hand.checkwin()){
                return;
            }
            if(h.hand.sum()[0] > highest && h.hand.sum()[0] < 21){
                highest = h.hand.sum()[0];
            }
            if(h.hand.sum()[1] > highest && h.hand.sum()[1] < 21){
                highest = h.hand.sum()[1];
            }
        }
        for (Bot h: this.bots) {
            if (h.hand.sum()[0] == highest){
//                System.out.println("Player number " + h.hand.playerNum + " won with  the highest sum of: " + h.hand.sum()[0]);
                h.won = true;
                return;
            }
            if(h.hand.sum()[1] == highest){
//                System.out.println("Player number " + h.hand.playerNum + " won with  the highest sum of: " + h.hand.sum()[1]);
                h.won = true;
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
