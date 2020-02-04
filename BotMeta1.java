package random_tarigilim.poker;

public class BotMeta1 extends Bot {
    public BotMeta1(int serialnumber, int botKindnum, boolean won) { super(serialnumber, botKindnum, won); }
    @Override
    public boolean turn() {
        super.turn();
        int[] sumHand = {super.hand.sum()[0], super.hand.sum()[1]};
        if (sumHand[0] <= 14 || sumHand[1] <= 14){
            return true;
        }
        return false;
    }
}
