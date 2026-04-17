package StockManagmentSystem;

import javax.swing.*;
import java.awt.event.ActionListener;

public class productOverview extends JFrame {
    private JButton sellItemButton;
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


    public void loadWindow(ActionListener listener,StockItem unit){
        setTitle(("Overview: "+unit.getStockName()+" - "+unit.getStockCode()));
        setContentPane(overviewPannel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        unitsInStockText.setText(String.valueOf(unit.getStockLevel()));
        costWithVAT.setText(String.valueOf(unit.getPriceWithVAT()));
        productNameText.setText(unit.getStockName());
        unitCostText.setText(String.valueOf(unit.getStockPrice()));
        itemDescriptionText.setText(unit.getStockDescription());
        vatRateText.setText(String.valueOf(unit.getVatRate()));

    }


}
