package random_tarigilim.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();

    public Deck() {

        int countnum = 0, countshape = 0;
        char whatchar = ' ';

        for (int i = 0; i < 52; i++) {
            countnum++;
            if (countshape == 0) {
                whatchar = 'H';
            } else if (countshape == 1) {
                whatchar = 'S';
            } else if (countshape == 2) {
                whatchar = 'D';
            } else if (countshape == 3) {
                whatchar = 'C';
            }
            this.cards.add(new Card(countnum, i, whatchar, 4 / 52));
            if (countnum == 13) {
                countnum = 0;
                countshape++;
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void print() {
        for (Card card : this.cards) {
            System.out.println("Number: " + card.num + ", Shape: " + card.shape);
        }
    }


    public Card hit() {
        Card tmp = this.cards.get(this.cards.size() - 1);
        this.cards.remove(this.cards.size() - 1);
        return tmp;
    }
}