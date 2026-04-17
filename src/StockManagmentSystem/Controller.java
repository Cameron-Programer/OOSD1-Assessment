package StockManagmentSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private stockList stockWindow = new stockList();
    private newProductForm newProductWindow = new newProductForm();
    private productOverview productWindow;

    public void init() {
        //StockItem unit = new StockItem("VW01",32,19.22);

        stockWindow.loadWindow(this);
        //stockWindow.addItemtoList(unit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Add new stock") {
            newProductWindow = new newProductForm();
            newProductWindow.loadWindow(this);
        } else if (e.getActionCommand() == "Save") {
            stockWindow.setVisible(true);
            newProductWindow.dispose();

            StockItem unit = new StockItem(newProductWindow.getProductCode(), newProductWindow.getProductStockLevel(), newProductWindow.getProductPrice());
            stockWindow.addItemtoList(unit);
        } else if (e.getActionCommand()=="Open") {
            System.out.println(stockWindow.getSelectedValue());
            productWindow = new productOverview();
            productWindow.loadWindow(this,stockWindow.getSelectedValue());


        }else {
            System.out.println(e.getSource());
            System.out.println(e.getID());
        }
    }
}

