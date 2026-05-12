package StockManagmentSystem;

import javax.swing.*;
import java.awt.event.ActionListener;

// (C) Cameron Mackie 2026. UweID 25014567
// Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)

public class productOverview extends JFrame {
    private JLabel productImage;
    private JLabel unitsInStock;
    private JLabel costWithVAT;
    private JTextField productNameText;
    private JTextField unitCostText;
    private JTextField itemDescriptionText;
    private JTextField unitsInStockText;
    private JTextField vatRateText;
    private JButton updateButton;
    private JPanel overviewPannel;
    private JButton sellItemButton;
    private JButton addStockButton;


    public void loadWindow(ActionListener listener,StockItem unit){
        setTitle(("Overview: "+unit.getStockName()+" - "+unit.getStockCode()));
        setContentPane(overviewPannel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        updateButton.addActionListener(listener);

        sellItemButton.addActionListener(listener);
        addStockButton.addActionListener(listener);


        unitsInStockText.setText(String.valueOf(unit.getStockLevel()));
        costWithVAT.setText(String.valueOf(unit.getPriceWithVAT()));
        productNameText.setText(unit.getStockName());
        unitCostText.setText(String.valueOf(unit.getStockPrice()));
        itemDescriptionText.setText(unit.getStockDescription());
        vatRateText.setText(String.valueOf(unit.getVatRate()));

    }


    public String getProductNameText() {
        return productNameText.getText();
    }

    public double getUnitCost() {
        return Double.parseDouble(unitCostText.getText());
    }

    public String getItemDescriptionText() {
        return itemDescriptionText.getText();
    }

    public Integer getUnitsInStock() {
        return Integer.parseInt(unitsInStockText.getText());
    }

    public double getVatRate() {
        return Double.parseDouble(vatRateText.getText());
    }


    public void refresh(StockItem unit){
        unitsInStockText.setText(String.valueOf(unit.getStockLevel()));
        costWithVAT.setText(String.valueOf(unit.getPriceWithVAT()));
        productNameText.setText(unit.getStockName());
        unitCostText.setText(String.valueOf(unit.getStockPrice()));
        itemDescriptionText.setText(unit.getStockDescription());
        vatRateText.setText(String.valueOf(unit.getVatRate()));
    }
}
