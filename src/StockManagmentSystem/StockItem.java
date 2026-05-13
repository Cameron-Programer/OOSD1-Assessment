package StockManagmentSystem;

// (C) Cameron Mackie 2026. UweID 25014567
// Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)


import javax.swing.JOptionPane;

public class StockItem {
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


    public StockItem(String stockCode, int stockLevel, double stockPrice, double vatRate){
        this.stockCode = stockCode;
        this.stockLevel = stockLevel;
        this.stockPrice = stockPrice;
        this.vatRate = vatRate;
    }

    // Getters and setters

    // stockCode setter and getter
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    // Name setter and getter
    public String getStockName() {
        return ("Unknown Stock Name");
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    //Description setter and getter
    public String getStockDescription() {
        return ("Unknown Stock Description");
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }

    // Level setter and getter
    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        if (stockLevel>100){
            JOptionPane.showMessageDialog(null,"Error: You cannot stock more than 100 units");
        }else if (stockLevel< 0)
        {
            JOptionPane.showMessageDialog(null,"Error: You cannot stock more less than 0 unit");
        }else {
            this.stockLevel = stockLevel;
        }
    }


    // Price setter and getters, Odd number since the price with vat is calculated by taking the stockPrice and multiplying it with the VAT rate.
    public double getStockPrice() {
        return stockPrice;
    }

    public double getPriceWithVAT() {
        return ((stockPrice * vatRate) + stockPrice);
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }


    // VAT Setter and Getter, allows for the user to input 20 or .20 when setting the VAT rate to 20%.
    public double getVatRate() {
        return vatRate*100;
    }

    public void setVatRate(double vatRate) {
        System.out.println(vatRate);
        if (vatRate >= 1) {
            this.vatRate = (vatRate / 100);
        } else {
            this.vatRate = vatRate;
        }
    }


    // Functions for the item (sell units, stock units. Has guards against employee error)
    //--------------------------

    public void addStock(int additionalStock) {
        if (additionalStock < 1) {
            JOptionPane.showMessageDialog(null,"ERROR:You have attempted to add 0 or less stock, if you want to sell stock please use the correct form.");
        } else if ((additionalStock + stockLevel) > 100) {
            JOptionPane.showMessageDialog(null,"ERROR: Please check your numbers, you cannot have more than 100 units in stock of the same item.");
        } else {
            stockLevel = stockLevel + additionalStock;
        }

    }

    public void sellStock(int unitsSold) {
        if (unitsSold < 1) {
            JOptionPane.showMessageDialog(null,"ERROR: You cannot sell less that one unit.");
        } else if ((stockLevel - unitsSold) < 0) {
            JOptionPane.showMessageDialog(null,"ERROR: You cannot sell more units than you have in stock.");
        } else {
            stockLevel = stockLevel - unitsSold;
        }
    }


    //Used name stockToString rather than toString as IDE was giving warning that toString would overide a java.lang function
    public String toString() {
        // NOTE: this method is different from the brif as in the GUI I use a JList of the stockItem class,
        // when using the method described in the brif it made it difficult for a user to use because of the amount of
        // text on screen.
        // Permission was granted to do this on 20/04/26 by Dr.Qurat-ul-ain Mastoi. Conditional that I justify the change in the video.

        // The method that was required from the brief is in the comment below and is also avaliable in the methods consoleOutput() and fullInformationToString()


        //return ("Stock code:" + getStockCode() + " \nStock name:" + getStockName() +" \nDescription: "+getStockDescription()+" \nStock level:" + String.valueOf(getStockLevel()) + " \nVat:" + String.valueOf(getVatRate()) + "%" + " \nPrice: "+getStockPrice()+" \nVAT Price: "+getPriceWithVAT());
        return("Stock code: "+getStockCode()+" Stock Name: "+getStockName());
    }


    // This is just the code that used to be in the toString methord, this can be used during testing.
    public void consoleOutput(){
        System.out.println("Stock code:" + getStockCode() + " \nStock name:" + getStockName() +" \nDescription: "+getStockDescription()+" \nStock level:" + String.valueOf(getStockLevel()) + " \nVat:" + String.valueOf(getVatRate()) + "%" + " \nPrice: "+getStockPrice()+" \nVAT Price: "+getPriceWithVAT());
    }
    public String fullInfomationToString(){
        return ("\nStock code:" + getStockCode() + " \nStock name:" + getStockName() +" \nDescription: "+getStockDescription()+" \nStock level:" + String.valueOf(getStockLevel()) + " \nVat:" + String.valueOf(getVatRate()) + "%" + " \nPrice: "+getStockPrice()+" \nVAT Price: "+getPriceWithVAT());
    }



}
