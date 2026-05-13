package StockManagmentSystem;

public class WindowTint extends StockItem {

    private int strength;

    // This is the constructor, this is fetching the window tintStrength aswell as the required variables for the StockItem.
    public WindowTint(String stockCode, int stockLevel, double stockPrice, int strength) {
        super(stockCode, stockLevel, stockPrice);
        this.strength = strength;
    }

    // Getters and Setters
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // This is the overrides, so in this we are overriding getStockName and getStockDescription to return info about the Tint.
    @Override
    public String getStockName() {
        return ("Window Tint");
    }

    @Override
    public String getStockDescription() {
        return (getStrength() + "% UV and light blocking film for windows");
    }
}
