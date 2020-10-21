package view;

import controller.Controller;
import model.*;

import java.sql.SQLException;
import java.util.List;

public class TableHandler {

    public TableHandler(Table table){
        Handler(table);

    }

    private void Handler(Table table){

    }


    public void setAllEmployee(Table table) throws SQLException {

        table.getTableModel().setRowCount(0);

        String[] columnNames = {"ID", "Фамилия", "Разряд", "Должность", "Профсоюз"};
        table.getTableModel().setColumnIdentifiers(columnNames);

        for (Employee employee : Controller.getContr().getAllEmployee()) {
                table.getTableModel().addRow(new Object[]{employee.getId(), employee.getLastName(), employee.getCategory(), employee.getPost(), employee.isTradeUnion()});
        }

    }

    public void setAllSalary(Table table) throws SQLException {
        table.getTableModel().setRowCount(0);
        for (Salary salary : Controller.getContr().getAllSalary()) {
            table.getTableModel().addRow(new Object[]{salary.getMonth(), salary.getMinSalary()});
        }

        String[] columnNames = {"Месяц", "Минимальная оплата труда"};
        table.getTableModel().setColumnIdentifiers(columnNames);
    }

    public void setAllTariff(Table table) throws SQLException {

        String[] columnNames = {"Разряд", "Коэффициент"};
        table.getTableModel().setColumnIdentifiers(columnNames);
        table.getTableModel().setRowCount(0);
        for (Tariff tariff : Controller.getContr().getAllTariff()) {
            table.getTableModel().addRow(new Object[]{tariff.getCategory(), tariff.getCoefficient()});
        }


    }

    public void setAllPayroll(Table table) throws SQLException {

        String[] columnNames = {"Месяц", "ID", "Начислено", "Удержано", "К выплате"};
        table.getTableModel().setColumnIdentifiers(columnNames);
        table.getTableModel().setRowCount(0);
        for (Payroll payroll : Controller.getContr().getAllPayroll()) {
            table.getTableModel().addRow(new Object[]{payroll.getMonth(), payroll.getId(), payroll.getAccruedAmount(), payroll.getWithheldAmount(), payroll.getAmountToPayoff()});
        }
    }

    public void setMinPayroll(Table table, String month) throws SQLException {

        String[] columnNames = {"Месяц", "Фамилия", "Должность", "К выплате"};
        table.getTableModel().setColumnIdentifiers(columnNames);
        table.getTableModel().setRowCount(0);
        System.out.println();
        for (Payroll payroll : Controller.getContr().getMinPayroll(month)) {
            table.getTableModel().addRow(new Object[]{payroll.getMonth(), payroll.getLastName(),payroll.getPost(), payroll.getAmountToPayoff()});
        }
    }

    public void setEmplMonthPayroll(Table table, String month, String lastName) throws SQLException {

        String[] columnNames = {"Месяц", "Фамилия", "Должность","Начислено", "Удержано", "К выплате"};
        table.getTableModel().setColumnIdentifiers(columnNames);
        table.getTableModel().setRowCount(0);
        System.out.println();
        for (Payroll payroll : Controller.getContr().getEmplMonthPayroll(month, lastName)) {
            table.getTableModel().addRow(new Object[]{payroll.getMonth(), payroll.getLastName(),payroll.getPost(), payroll.getAccruedAmount(), payroll.getWithheldAmount(), payroll.getAmountToPayoff()});
        }
    }


}
