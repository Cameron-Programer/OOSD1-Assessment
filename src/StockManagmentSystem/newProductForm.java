package StockManagmentSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newProductForm extends JFrame {
    private JTextField ProductCode;
    private JTextField Price;
    private JTextField ProductName;
    private JTextField VatRate;
    private JTextField UnitsOfStock;
    private JButton saveButton;
    private JButton abortButton;
    private JPanel NewProductWindow;


    public void loadWindow(ActionListener listener) {
        setTitle("New Stock Creation Wizard");
        setContentPane(NewProductWindow);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        abortButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        VatRate.setText("20");

        abortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public double getVatRate(){return Double.parseDouble(VatRate.getText());}

    public String getProductCode(){
        return ProductCode.getText();
    }

    public double getProductPrice(){
        return Double.parseDouble(Price.getText());
    }

    public int getProductStockLevel(){
        return Integer.parseInt(UnitsOfStock.getText());
    }

    public String getProductName(){
        return ProductName.getText();
    }

}

