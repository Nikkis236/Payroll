package view;


import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ChildWindow extends JFrame {
    protected JDialog dialog = new JDialog();
    String[] columnNames = {"фио студента", "группа", "по болезни", "по другим причинам", "без уважительной причины", "итого"};
    protected Table table = new Table(columnNames);

    protected DefaultTableModel mode;
    protected JPanel pagesPanel = new JPanel();
    protected JPanel mainPanel = new JPanel(new BorderLayout());
    protected JPanel panel = new JPanel(new GridLayout(4,1,2,2));
    protected JPanel employeeLabelBox = new JPanel(new GridLayout(1,4,2,2));
    protected JPanel tariffLabelBox = new JPanel(new GridLayout(1,2,2,2));
    protected JPanel employeeInputBox = new JPanel(new GridLayout(1,4,2,2));
    protected JPanel tariffInputBox = new JPanel(new GridLayout(1,2,2,2));
    protected JLabel idLabel = new JLabel("ID");
    protected JLabel lastNameLabel = new JLabel("Last name");
    protected JLabel categoryLabel = new JLabel("Category");
    protected JLabel postLabel = new JLabel("Post");
    protected JLabel tradeUnionLabel = new JLabel("Trade union");

    protected JTextField inputID = new JTextField();
    protected JTextField inputLastName = new JTextField();
    protected JTextField inputCategory = new JTextField();
    protected JTextField inputPost = new JTextField();
    protected JTextField inputTradeUnion = new JTextField();
    protected JLabel categoryTLabel = new JLabel("Category");
    protected JLabel coefficientLabel = new JLabel("Coefficient");
    protected JTextField inputTCategory = new JTextField();
    protected JTextField inputCoefficient = new JTextField();


    private JTextField empty1 = new JTextField();
    private JTextField empty2 = new JTextField();


    protected TableHandler tableHandlerFilter = new TableHandler(table);

    public ChildWindow() throws SQLException {
        dialog = createDialog("", true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        makeGUI();
        Handler();

    }

    public void makeGUI() throws SQLException {


        dialog.add(mainPanel);
        dialog.add(panel,BorderLayout.BEFORE_FIRST_LINE);

        mainPanel.add(new JScrollPane(table.table));
        for(JComponent r: Arrays.asList(employeeLabelBox, employeeInputBox,tariffLabelBox, tariffInputBox)) {
            panel.add(r);
        }

        for(JComponent r: Arrays.asList(idLabel, lastNameLabel, categoryLabel, postLabel, tradeUnionLabel)) {
            employeeLabelBox.add(r);
        }
        for(JComponent r: Arrays.asList(inputID, inputLastName, inputCategory, inputPost, inputTradeUnion)) {
            employeeInputBox.add(r);
        }
        for(JComponent r: Arrays.asList(categoryTLabel, coefficientLabel)) {
            tariffLabelBox.add(r);
        }
        for(JComponent r: Arrays.asList(inputTCategory, inputCoefficient)) {
            tariffInputBox.add(r);
        }
        empty1.setVisible(false);
        empty2.setVisible(false);


        tableHandlerFilter.setAllSalary(table);

    }



    public void Handler (){


    }


    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(400, 200);
        return dialog;
    }

}