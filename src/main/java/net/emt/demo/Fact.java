package net.emt.demo;

public class Fact {
    private int id;
    private int queenId;
    private String fact;

    public Fact() {
    }

    public Fact(int id, int queenId, String fact) {
        this.id = id;
        this.queenId = queenId;
        this.fact = fact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQueenId() {
        return queenId;
    }

    public void setQueenId(int queenId) {
        this.queenId = queenId;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
