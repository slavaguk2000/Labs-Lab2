package sample;

public class Worker {
    private String name;
    private int money;

    public Worker(){
        smoke();
    }

    public boolean work() {
        return true;
    }

    public boolean smoke() {
        burnMatch();
        return true;
    }

    public boolean burnMatch(){
        Match match = new Match();
        match.Burn();
        return true;
    }
}
