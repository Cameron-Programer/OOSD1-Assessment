package StockManagmentSystem;

// (C) Cameron Mackie 2026. UweID 25014567
// Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)

import javax.swing.*;

public class TestPolymorphism {

    /*
    The main methord here simply creates an array of StockItem's called items, it then adds all the subclasses of StockItem to that array.


     */

    public static void main(String[] args) {
        StockItem[] items = new StockItem[4];
        LightBar light = new LightBar("LB1", 10, 100, 3200);
        MusicalHorn horn = new MusicalHorn("MH1", 10, 100, "Despacito");
        WindowTint tint = new WindowTint("WTL1", 10, 100, 15);
        NavSys satNav = new NavSys("GEO1",10,100);
        StockItem unit = new StockItem("SI1",10,100);
        items[0] = light;
        items[1] = horn;
        items[2] = tint;
        items[3] = satNav;

        for (int i = 0; i < items.length; i++) {
            itemInstance(items[i]);
        }

    }

    public static void itemInstance(StockItem unit) {
        /*
        This section is asking the user what changes they would like to make with the unit infomation included in that box.
        rather than using a scanner to take input and System.out.println to display infomation ive used JOptionPane. Since it is just a bit easier to read and understand.
        This does also output the state into the console using the method StockItem.consoleOutput().
        */
        System.out.println("Outputting stock information:");
        unit.consoleOutput();
        int remove = Integer.parseInt(JOptionPane.showInputDialog("How many units do you want to sell\n----------" + unit.fullInfomationToString()));
        unit.sellStock(remove);
        System.out.println("----------Units updated");
        unit.consoleOutput();
        int add = Integer.parseInt(JOptionPane.showInputDialog("How many units do you want to add\n----------" + unit.fullInfomationToString()));
        unit.addStock(add);
        System.out.println("----------Units Updated");
        unit.consoleOutput();
        double price = Double.parseDouble(JOptionPane.showInputDialog("What price would you like to set for this product\n----------" + unit.fullInfomationToString()));
        unit.setStockPrice(price);
        System.out.println("----------Price Updated");
        unit.consoleOutput();
        JOptionPane.showMessageDialog(null,("Final state of "+ unit.toString() + "\n----------\n"+unit.fullInfomationToString()));
        System.out.println("---------------------------- itemInstance Finished");
        System.out.println();

    }

}