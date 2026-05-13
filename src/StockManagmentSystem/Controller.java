package StockManagmentSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// (C) Cameron Mackie 2026. UweID 25014567
// Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)

// In effect this is the main class for Part One.

// We are implmenting Action Listener so we can pass this to the GUI, this allows us to run code here when buttons are pressed in the GUI
public class Controller implements ActionListener {
    //This is just getting the GUI classes into objects.
    private stockList stockWindow = new stockList();
    private newProductForm newProductWindow = new newProductForm();
    private productOverview productWindow;

    // This simply loads the stockList window and passes iteself into as the ActionListener.
    public void main() {
        //StockItem unit = new StockItem("VW01",32,19.22);

        stockWindow.loadWindow(this);
        //stockWindow.addItemtoList(unit);
    }

    // We are overiding the Action performed from the ActionListener that we implmented at the top.
    // so e is the Event that occured in the GUI.
    @Override
    public void actionPerformed(ActionEvent e) {
        // This is checking what the Text on the button that was clicked says, using this we can detemin what should occur.
        switch (e.getActionCommand()) {
            // For example this is the "Add new stock" button, so we need to open the newProductWindow.
            case ("Add new stock"):
                newProductWindow = new newProductForm();
                newProductWindow.loadWindow(this);
                break;

            case ("Save"):
                stockWindow.setVisible(true);
                newProductWindow.dispose();
                StockItem unit = new StockItem(newProductWindow.getProductCode(), newProductWindow.getProductStockLevel(), newProductWindow.getProductPrice());
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

               //Confirming changes, This just compares the current Values of the Object and the values of the GUI,
                // if they are diffrent we know that the user has made a change, then we add that to the confirmMessage string so
                // they can confirm that is what they wanted to change.

                // We are using a flag system to check if any changes had been made, if no changes are made the flag will remain false so
                // the popup will not appear since there is nothing to confirm.

               boolean changeFlag = false;
               String confirmMessage = "Please confirm the following changes:\n";
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
                   }else{
                       productWindow.refresh(target);
                   }
               }
               break;
            case ("Sell item"):
                stockWindow.getSelectedValue().sellStock(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number of units you want to sell:")));
                productWindow.refresh(stockWindow.getSelectedValue());
                break;

            case ("Add Stock"):
                stockWindow.getSelectedValue().addStock(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number of units you want to add:")));
                productWindow.refresh(stockWindow.getSelectedValue());
                break;


            default:
                System.out.println("WARNING: Button pressed has ActionEvent but no logic in the controller.");
                break;
        }
    }
}

