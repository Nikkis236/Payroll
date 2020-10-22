package controller;

import DAO.EmployeeDAO;
import DAO.PayrollDAO;
import DAO.SalaryDAO;
import DAO.TariffDAO;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Controller controller;

    EmployeeDAO employeeDAO;
    PayrollDAO payrollDAO;
    SalaryDAO salaryDAO;
    TariffDAO tariffDAO;


    private Controller(){
        employeeDAO =new EmployeeDAO();
        payrollDAO = new PayrollDAO();
        salaryDAO = new SalaryDAO();
        tariffDAO =new TariffDAO();
    }

    public static Controller getContr(){
            if(controller == null){
                controller = new Controller();
            }
            return controller;
    }


    public List<Employee> getAllEmployee() throws SQLException {
        return employeeDAO.findAll(); }
    public List<Payroll> getAllPayroll() throws SQLException {
        return payrollDAO.findAll(); }
    public List<Salary> getAllSalary() throws SQLException {
        return salaryDAO.findAll(); }
    public List<Tariff> getAllTariff() throws SQLException {
        return tariffDAO.findAll(); }


    public void addEmployee(String id, String lastName, int category, String post, boolean tradeUnion) throws SQLException {
        employeeDAO.create(id, lastName, category, post, tradeUnion);
    }

    public void addTariff(int category, double coefficient) throws SQLException {
        tariffDAO.create(category, coefficient);
    }

    public List<Payroll> getMinPayroll(String month) throws SQLException {
        return payrollDAO.findMinPayroll(month);
    }

    public List<Payroll> getEmplMonthPayroll(String month, String lastName) throws SQLException {
        return payrollDAO.findEmplMonthPayroll(month, lastName);
    }

    public void deleteEmployee(String id) throws SQLException {
        employeeDAO.delete(id);
    }

    public void deleteTariff(int category) throws SQLException {
        tariffDAO.delete(category);
    }

    public void editEmployee(String id, String lastName,  int category, String post, Boolean tradeUnion) throws SQLException {
        employeeDAO.edit(id, lastName, category, post, tradeUnion);
    }

    public void editTariff(int category, double coefficient) throws SQLException {
        tariffDAO.edit(category, coefficient);
    }



}
