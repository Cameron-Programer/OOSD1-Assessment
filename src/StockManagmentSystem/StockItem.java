package StockManagmentSystem;

class StockItem {
    private String stockCode;
    private String stockName;
    private String stockDescription;
    private int stockLevel;
    private double vatRate;
    private double stockPrice;

    //Constructor
    public StockItem(String stockCode, int stockLevel, double stockPrice){
        this.stockCode = stockCode;
        this.stockLevel = stockLevel;
        this.stockPrice = stockPrice;
    }

    // Getters and setters

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public double getVatRate() {
        return vatRate;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getStockName() {
        return ("Unknown Stock Name");
    }

    public String getStockDescription() {
        return ("Unknown Stock Description");
    }


    public double getPriceWithVAT() {
        return ((stockPrice * vatRate) + stockPrice);
    }


    // Functions for the item (sell units, stock units. Has guards against employee error)
    //--------------------------

    public String addStock(int additionalStock) {
        if (additionalStock < 1) {
            return ("ERROR:You have attempted to add 0 or less stock, if you want to sell stock please use the correct form.");
        } else if ((additionalStock + stockLevel) > 100) {
            return ("ERROR: Please check your numbers, you cannot have more than 100 units in stock of the same item.");
        } else {
            stockLevel = stockLevel + additionalStock;
            return ("SUCESS: Stock level has been updated \n You have " + String.valueOf(stockLevel) + " units in stock");
        }

    }

    public String sellStock(int unitsSold) {
        if (unitsSold < 1) {
            return ("ERROR: You cannot sell less that one unit.");
        } else if ((stockLevel - unitsSold) < 0) {
            return ("ERROR: You cannot sell more units than you have in stock.");
        } else {
            stockLevel = stockLevel - unitsSold;
            return ("SUCCESS: Stock level has been updated \n You have " + String.valueOf(stockLevel) + " units left in stock");
        }
    }


    //Used name stockToString rather than toString as IDE was giving warning that toString would overide a java.lang function
    public String toString() {
        return ("Stock code:" + stockCode + "\nStock name:" + stockName + "\nStock level:" + String.valueOf(stockLevel) + "\nVat:" + String.valueOf(vatRate) + "%");
    }

    public void setVatRate(double vatRate) {
        System.out.println(vatRate);
        if (vatRate >= 1) {
            this.vatRate = vatRate / 100;
        } else {
            this.vatRate = vatRate;
        }
        System.out.println(this.vatRate);
    }

}
