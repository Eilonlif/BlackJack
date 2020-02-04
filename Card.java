package random_tarigilim.poker;

public class Card {
    public char shape;
    public int num;
    public int serialNum;
    public double chance;

    public Card(int number, int serialNumber, char shape, double chance) {
        this.shape = shape;
        this.num = number;
        this.serialNum = serialNumber;
        this.chance = chance;
    }
}
