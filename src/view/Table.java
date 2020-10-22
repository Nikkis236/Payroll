package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Table {
    private  DefaultTableModel model;
    public JTable table;


    Table (String[] columnNames){
        model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);

    }

    public DefaultTableModel getTableModel(){
        return model;
    }
    public  DefaultTableModel getModel (){return model;}




}