package random_tarigilim.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> hand = new ArrayList<Card>();
    public boolean folded = false;
    public int playerNum;

    public Hand(int playerNumber){
        this.playerNum = playerNumber;
    }

    public int[] sum(){
        int[] sum = {0, 0};
        for (Card card : this.hand) {
            if (card.num == 1){
                sum[0] += 1;
                sum[1] += 11;
            }
            else if(card.num >= 10){
                sum[0] += 10;
                sum[1] += 10;
            }
            else{
                sum[0] += card.num;
                sum[1] += card.num;
            }
        }
        return sum;
    }

    public void addCard(Card c) {
        this.hand.add(c);
    }

    public void print(){
        for (Card card : this.hand) {
            System.out.println("Number: " + card.num + ", Shape: " + card.shape);
        }
    }

    public boolean checkwin(){
        if(this.sum()[0] == 21 || this.sum()[1] == 21){
            return true;
        }
        return false;
    }
}
