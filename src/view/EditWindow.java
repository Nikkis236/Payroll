package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class EditWindow extends ChildWindow {

    private JPanel editPanel = new JPanel(new GridLayout(1,2,2,2));
    private JButton editEmployeeButt = new JButton("Edit Employee");
    private JButton editTarifButt = new JButton("Edit Tariff");


    public EditWindow() throws SQLException {
        super();

        editEmployeeButt.addActionListener(new EmployeeEditing());
        editTarifButt.addActionListener(new TariffEditing());
        dialog.add(editPanel,BorderLayout.CENTER);
        pagesPanel.setVisible(false);
        mainPanel.setVisible(false);

        editPanel.add(editEmployeeButt);
        editPanel.add(editTarifButt);

        dialog.setVisible(true);

    }

    class EmployeeEditing implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Controller.getContr().editEmployee(inputID.getText(), inputLastName.getText(), Integer.parseInt(inputCategory.getText()), inputPost.getText(), Boolean.parseBoolean(inputTradeUnion.getText()));
                //mode.addRow(new Object[]{inputName.getText(), inputGroup.getText(), inputIllnessLow.getText(), inputOtherLow.getText(), inputWithoutReasonLow.getText(), inputTotalLow.getText()});
                tableHandlerFilter.setAllEmployee(table);
            }catch(NumberFormatException | SQLException ex){}

        }
    }

    class TariffEditing implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                Controller.getContr().editTariff(Integer.parseInt(inputTCategory.getText()), Double.parseDouble(inputCoefficient.getText()));
                System.out.println(inputCoefficient.getText());
                //mode.addRow(new Object[]{inputName.getText(), inputGroup.getText(), inputIllnessLow.getText(), inputOtherLow.getText(), inputWithoutReasonLow.getText(), inputTotalLow.getText()});
                tableHandlerFilter.setAllTariff(table);
            }catch(NumberFormatException | SQLException ex){}

        }
    }


    public DefaultTableModel getModel (){
        return mode;
    }


}