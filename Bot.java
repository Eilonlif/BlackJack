package random_tarigilim.poker;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    public boolean won;
    public final int botnum;
    public final int botKindnum;
    protected Hand hand;
    public Bot(int serialNumber, int botKindnum, boolean won){
        this.botKindnum = botKindnum;
        this.botnum = serialNumber;
        this.hand = new Hand(serialNumber);
        this.won = won;
    }

    public boolean turn(){
        return false;
    }
}
