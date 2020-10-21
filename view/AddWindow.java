package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class AddWindow extends ChildWindow {

    private JPanel addPanel = new JPanel(new GridLayout(1,2,2,2));
    private JButton addEmployeeButt = new JButton("Add Employee");
    private JButton addTarifButt = new JButton("Add Tariff");


    public AddWindow() throws SQLException {
        super();

        addEmployeeButt.addActionListener(new EmployeeAdding());
        addTarifButt.addActionListener(new TariffAdding());
        dialog.add(addPanel,BorderLayout.CENTER);
        pagesPanel.setVisible(false);
        mainPanel.setVisible(false);

        addPanel.add(addEmployeeButt);
        addPanel.add(addTarifButt);

        dialog.setVisible(true);

    }

    class EmployeeAdding implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Controller.getContr().addEmployee(inputID.getText(), inputLastName.getText(), Integer.parseInt(inputCategory.getText()), inputPost.getText(), Boolean.parseBoolean(inputTradeUnion.getText()));
                //mode.addRow(new Object[]{inputName.getText(), inputGroup.getText(), inputIllnessLow.getText(), inputOtherLow.getText(), inputWithoutReasonLow.getText(), inputTotalLow.getText()});
                tableHandlerFilter.setAllEmployee(table);
            }catch(NumberFormatException | SQLException ex){}

        }
    }

    class TariffAdding implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Controller.getContr().addTariff(Integer.parseInt(inputTCategory.getText()), Double.parseDouble(inputCoefficient.getText()));
                //mode.addRow(new Object[]{inputName.getText(), inputGroup.getText(), inputIllnessLow.getText(), inputOtherLow.getText(), inputWithoutReasonLow.getText(), inputTotalLow.getText()});
                tableHandlerFilter.setAllEmployee(table);
            }catch(NumberFormatException | SQLException ex){}

        }
    }


    public DefaultTableModel getModel (){
        return mode;
    }


}