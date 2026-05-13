package StockManagmentSystem;

public class LightBar extends StockItem{
    private int lumins;

    // This is implmenting polymorphic constructors, depending on what inputed will change what is run
    // So this allows for us to also include VAT or not and both will be valid
    public LightBar(String stockCode, int stockLevel, double stockPrice, int lumins) {
        super(stockCode, stockLevel, stockPrice);
        this.lumins = lumins;
    }

    public LightBar(String stockCode, int stockLevel, double stockPrice, int lumins,int vatRate) {
        super(stockCode, stockLevel, stockPrice,vatRate);
        this.lumins = lumins;


    }

    // getters and setters
    public int getLumins() {
        return lumins;
    }

    public void setLumins(int lumins) {
        this.lumins = lumins;
    }


    // This is overriding the getters for stock name and stock description.
    @Override
    public String getStockName(){
        return("Light Bar");
    }

    @Override
    public String getStockDescription(){
        return ("Roof light bar that provides 360 lighting. Lumins:"+getLumins());
    }
}
