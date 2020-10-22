package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.Controller;

public class DeleteWindow extends ChildWindow {
    private JPanel deleteBtnPanel = new JPanel(new GridLayout(1,2,2,2));
    private JButton deleteTariffButt = new JButton("Del tariff by category");
    private JButton deleteEmployeeButt = new JButton("Del employee by id");
    private JPanel deletePanel = new JPanel(new GridLayout(2,1,2,2));
    private JPanel categoryPanel = new JPanel(new GridLayout(1,2,2,2));
    private JPanel idPanel = new JPanel(new GridLayout(1,2,2,2));
    protected JLabel categoryDelLabel = new JLabel("category");
    protected JLabel idDelLabel = new JLabel("id");
    protected JTextField inputDelCategory = new JTextField();
    protected JTextField inputDelId = new JTextField();

    public DeleteWindow(DefaultTableModel model) throws SQLException {
        super();

        mainPanel.setVisible(false);
        panel.setVisible(false);
        table.getTableModel().setRowCount(0);

        dialog.add(deletePanel, BorderLayout.BEFORE_FIRST_LINE);
        dialog.add(deleteBtnPanel,BorderLayout.SOUTH);

        deletePanel.add(idPanel);
        deletePanel.add(categoryPanel);

        idPanel.add(idDelLabel);
        idPanel.add(inputDelId);
        categoryPanel.add(categoryDelLabel);
        categoryPanel.add(inputDelCategory);

        deleteTariffButt.addActionListener(new DeleteWindow.TariffDeleting());
        deleteEmployeeButt.addActionListener(new DeleteWindow.EmployeeDeleting());
        deleteBtnPanel.add(deleteTariffButt);
        deleteBtnPanel.add(deleteEmployeeButt);
        dialog.setVisible(true);
    }

    class EmployeeDeleting implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Controller.getContr().deleteEmployee(inputDelId.getText());

                tableHandlerFilter.setAllEmployee(table);
            }catch(NumberFormatException | SQLException ex){}

        }
    }

    class TariffDeleting implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Controller.getContr().deleteTariff(Integer.parseInt(inputDelCategory.getText()));

                tableHandlerFilter.setAllEmployee(table);
            }catch(NumberFormatException | SQLException ex){}

        }
    }



}