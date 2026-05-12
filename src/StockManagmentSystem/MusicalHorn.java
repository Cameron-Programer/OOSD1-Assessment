package StockManagmentSystem;

public class MusicalHorn extends StockItem{
    private String song;

    //gettters and setters
    public String getSong() {
        return song;
    }
    public void setSong(String song) {
        this.song = song;
    }

    public MusicalHorn(String stockCode, int stockLevel, double stockPrice, String song) {
        super(stockCode, stockLevel, stockPrice);
        this.song = song;
    }

    // This is overriding the getters for stock name and stock description.
    @Override
    public String getStockName(){
        return("Musical Horn");
    }

    @Override
    public String getStockDescription(){
        return ("A musical horn that plays the song, "+getSong());
    }
}
