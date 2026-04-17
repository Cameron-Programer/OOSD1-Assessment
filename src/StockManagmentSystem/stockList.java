package StockManagmentSystem;
import javax.swing.*;
import java.awt.event.ActionListener;

public class stockList extends JFrame {
    private JPanel stockPannel;
    private JButton searchProductNameButton;
    private JButton searchStockNumberButton;
    private JList<StockItem> listOfStock;
    private JButton addNewStockButton;
    private JButton openButton;
    private DefaultListModel<StockItem> listOfStockList = new DefaultListModel<>();

    public void loadWindow(ActionListener listener) {

        listOfStock.setModel(listOfStockList);

        setTitle("ALPHA - Cameron's stock management");
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


}
