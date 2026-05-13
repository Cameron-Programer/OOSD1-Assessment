package StockManagmentSystem;

public class NavSys extends StockItem {

    // (C) Cameron Mackie 2026. UweID 25014567
    // Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)


    public NavSys(String stockCode, int stockLevel, double stockPrice) {
        super(stockCode, stockLevel, stockPrice);
    }


    // This is overriding the getters for stock name and stock description.
    @Override
    public String getStockName() {
        return ("Navigation system");
    }

    @Override
    public String getStockDescription() {
        return ("GeoVision Sat Nav");
    }
}
