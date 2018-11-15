package net.emt.demo;

public class Fact {
    private int id;
    private int queenId;
    private String quote;

    public Fact() {
    }

    public Fact(int id, int queenId, String quote) {
        this.id = id;
        this.queenId = queenId;
        this.quote = quote;
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

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
