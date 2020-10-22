package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainWindowHandler  {
    MainWindow mainWindow = new MainWindow();
    private TableHandler tableHandlerFilter = new TableHandler(mainWindow.table);


   public MainWindowHandler() throws SQLException {
        this.Handler();
        this.makeUI();
    }

    private void Handler() {

        class getAdd implements ActionListener{
            public void actionPerformed(ActionEvent e) {

                try {
                    new AddWindow();
                    tableHandlerFilter.setAllEmployee(mainWindow.table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        mainWindow.btnAdd.addActionListener(new getAdd());

        class getEdit implements ActionListener{
            public void actionPerformed(ActionEvent e) {

                try {
                    new EditWindow();
                    tableHandlerFilter.setAllEmployee(mainWindow.table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        mainWindow.btnEdit.addActionListener(new getEdit());


        class TariffListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try {

                    tableHandlerFilter.setAllTariff(mainWindow.table);
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        }
        mainWindow.btnTariff.addActionListener(new TariffListener());

        class getDel implements ActionListener{
            public void actionPerformed(ActionEvent e) {

                try {
                    new DeleteWindow(mainWindow.table.getModel());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    tableHandlerFilter.setAllEmployee(mainWindow.table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
        mainWindow.btnDel.addActionListener(new getDel());


        class EmployeeListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {

                    tableHandlerFilter.setAllEmployee(mainWindow.table);
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        }
        mainWindow.btnEmployee.addActionListener(new EmployeeListener());


        class SalaryListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try {

                    tableHandlerFilter.setAllSalary(mainWindow.table);
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        }
        mainWindow.btnSalary.addActionListener(new SalaryListener());

        class PayrollListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try {

                    tableHandlerFilter.setAllPayroll(mainWindow.table);
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        }
        mainWindow.btnPayroll.addActionListener(new PayrollListener());

        class SearchListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchWindow();
                 //   pageHandlerFilter.setFilter(mainWindow.studTable);
                    tableHandlerFilter.setAllEmployee(mainWindow.table);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
        mainWindow.btnSearch.addActionListener(new SearchListener());

    }



    public void  makeUI() throws SQLException {
        mainWindow.table.table.setFillsViewportHeight(true);
        tableHandlerFilter.setAllEmployee(mainWindow.table);


    }


}