package StockManagmentSystem;
import javax.swing.*;
import java.awt.event.ActionListener;

// (C) Cameron Mackie 2026. UweID 25014567
// Project for OOSD1 module on the Software Eng course At the University of the West of England (UWE)


public class stockList extends JFrame {
    private JPanel stockPannel;
    private JList<StockItem> listOfStock;
    private JButton addNewStockButton;
    private JButton openButton;
    private DefaultListModel<StockItem> listOfStockList = new DefaultListModel<>();

    public void loadWindow(ActionListener listener) {

        listOfStock.setModel(listOfStockList);
        setTitle("Cameron's stock management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(stockPannel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        openButton.addActionListener(listener);
        addNewStockButton.addActionListener(listener);
    }

    public void addItemtoList(StockItem unit){
        listOfStockList.addElement(unit);
        System.out.println(unit);
    }

    public StockItem getSelectedValue(){
        return listOfStock.getSelectedValue();
    }

    public Integer getSelectedIndex(){
        return listOfStock.getSelectedIndex();
    };

    public void replaceItemAtIndex(Integer index,StockItem unit){
        listOfStockList.set(index,unit);
    }


}
