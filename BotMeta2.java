package random_tarigilim.poker;

public class BotMeta2 extends Bot {
    public BotMeta2(int serialnumber, int botKindnum, boolean won) {
        super(serialnumber, botKindnum, won);
    }
    @Override
    public boolean turn() {
        super.turn();
        return true;
    }
}
