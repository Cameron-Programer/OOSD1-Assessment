package StockManagmentSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// (C) Cameron Mackie 2026. UweID 25014567
// Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)


public class TestNavSys implements ActionListener {
    private stockList stockWindow = new stockList();
    private newProductForm newProductWindow = new newProductForm();
    private productOverview productWindow;

    public void main() {
        //StockItem unit = new StockItem("VW01",32,19.22);

        stockWindow.loadWindow(this);
        //stockWindow.addItemtoList(unit);
    }

    // This section of code is reacting to button presses, Depending on what the buton says changes the behaviour of the system
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            /*
            This will run if the Add new stock button on the list is pressed
            It simply creates a new instance of the newProdcutForm and loads the window.
            This allows the user to input the infomation required to create a new instance of StockItem
            */
            case ("Add new stock"):
                newProductWindow = new newProductForm();
                newProductWindow.loadWindow(this);
                break;

            /*
            This will run if the Save button is pressed in the
             */
            case ("Save"):
                stockWindow.setVisible(true);
                newProductWindow.dispose();
                StockItem unit = new NavSys(newProductWindow.getProductCode(), newProductWindow.getProductStockLevel(), newProductWindow.getProductPrice());
                unit.setVatRate(newProductWindow.getVatRate());
                stockWindow.addItemtoList(unit);

                break;

            case ("Open"):
                if (productWindow != null){
                    productWindow.dispose();
            }
                System.out.println(stockWindow.getSelectedValue());
                productWindow = new productOverview();
                productWindow.loadWindow(this, stockWindow.getSelectedValue());
                break;
            case ("Update"):
               StockItem target = stockWindow.getSelectedValue();
               Integer targetPos = stockWindow.getSelectedIndex();

               //Confirming changes
               boolean changeFlag = false;
               String confirmMessage = "Please confirm the following changes:\n";
               /*
               if (target.getStockName() != productWindow.getProductNameText()){
                   confirmMessage = ("Product Name changed from: "+confirmMessage+target.getStockName()+" -> "+productWindow.getProductNameText()+"\n");
                   changeFlag = true;
               }
               */
               if (target.getStockPrice() != productWindow.getUnitCost()){
                   confirmMessage = (confirmMessage+"Unit Cost changed from: "+target.getStockPrice()+" -> "+productWindow.getUnitCost()+"\n");
                   changeFlag = true;
               }
               if (target.getVatRate() != productWindow.getVatRate()){
                   confirmMessage = (confirmMessage+"VAT rate changed from: "+target.getVatRate()+" -> "+productWindow.getVatRate()+"\n");
                   changeFlag = true;
               }
               if (target.getStockLevel() != productWindow.getUnitsInStock()){
                   confirmMessage = (confirmMessage+"Stock level changed from: "+target.getStockLevel()+" -> "+productWindow.getUnitsInStock()+"\n");
                   changeFlag = true;
               }

               if (changeFlag){
                   int userConfirmationResult = JOptionPane.showOptionDialog(null,confirmMessage,"Change Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                   if (userConfirmationResult == JOptionPane.YES_OPTION){
                       target.setVatRate(productWindow.getVatRate());
                       target.setStockDescription(productWindow.getItemDescriptionText());
                       target.setStockLevel(productWindow.getUnitsInStock());
                       target.setStockPrice(productWindow.getUnitCost());
                       stockWindow.replaceItemAtIndex(targetPos, target);
                       productWindow.refresh(target);
                   }
               }else {
                   target.setVatRate(productWindow.getVatRate());
                   target.setStockDescription(productWindow.getItemDescriptionText());
                   target.setStockLevel(productWindow.getUnitsInStock());
                   target.setStockPrice(productWindow.getUnitCost());
                   stockWindow.replaceItemAtIndex(targetPos, target);
                   productWindow.dispose();
               }
               break;
            case ("Sell item"):
                stockWindow.getSelectedValue().sellStock(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number of units you want to sell:")));
                productWindow.refresh(stockWindow.getSelectedValue());


            default:
                System.out.println("WARNING: Button pressed has ActionEvent but no logic in the controller.");
                break;
        }
    }
}

