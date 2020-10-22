package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchWindow extends ChildWindow {

    private JPanel searchBtnPanel = new JPanel(new GridLayout(1,2,2,2));
    private JButton minSearchButt = new JButton("Search min");
    private JButton monthSearchButt = new JButton("Search month payroll");
    private JPanel searchPanel = new JPanel(new GridLayout(2,1,2,2));
    private JPanel monthPanel = new JPanel(new GridLayout(1,2,2,2));
    private JPanel namePanel = new JPanel(new GridLayout(1,2,2,2));
    protected JLabel monthLabel = new JLabel("Month");
    protected JLabel lastNameLabel = new JLabel("Last name");
    protected JTextField inputMonth = new JTextField();
    protected JTextField inputLastName = new JTextField();




   // List<Student> stud;

    public SearchWindow() throws SQLException {
    super();


    panel.setVisible(false);
    table.getTableModel().setRowCount(0);

    dialog.add(searchPanel, BorderLayout.BEFORE_FIRST_LINE);
    dialog.add(searchBtnPanel,BorderLayout.SOUTH);

    searchPanel.add(namePanel);
    searchPanel.add(monthPanel);

    namePanel.add(lastNameLabel);
    namePanel.add(inputLastName);
    monthPanel.add(monthLabel);
    monthPanel.add(inputMonth);

    minSearchButt.addActionListener(new MinPayrollSearching());
    monthSearchButt.addActionListener((new MonthPayrollSearching()));
    searchBtnPanel.add(minSearchButt);
    searchBtnPanel.add(monthSearchButt);
    dialog.setVisible(true);
}

    class MinPayrollSearching implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                tableHandlerFilter.setMinPayroll(table,inputMonth.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    class MonthPayrollSearching implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                tableHandlerFilter.setEmplMonthPayroll(table,inputMonth.getText(),inputLastName.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }


}
