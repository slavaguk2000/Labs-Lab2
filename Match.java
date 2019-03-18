package sample;


public class Match extends Product {
    public static final int standartLength = 100;
    private int length;
    private boolean isBurning;
    private Fire fire;

    public Match() {
        length = standartLength;
        isBurning = false;
    }
    public Fire Burn() {
        if (!isBurning) {
            fire = new Fire();
            isBurning = true;
        }
        return fire;
    }
}
