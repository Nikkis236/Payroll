//import controller.
import javax.swing.*;

import DAO.PayrollDAO;
import model.Payroll;
import view.MainWindowHandler;

import java.sql.SQLException;


public class Main extends JDialog {

    
    public Main() {
    }


    public static void main(String[] args) throws SQLException {




        /*EmployeeDAO emp = new EmployeeDAO();
        emp.deleteInDB("111");
        emp.create("111","qwwert",5,"sfddfd",true);
        for (Employee em: emp.findAll()) {
            System.out.println(em.getLastName());

        }*/

        /*PayrollDAO t = new PayrollDAO();
        //t.deleteInDB(19);
        //t.create(19,5.4);
        for (Payroll em: t.findAll()) {
            System.out.println(em.getId());
            System.out.println(em.getAmountToPayoff());

        }*/

       // StudentController.getStudContr().setStudents(SAXRParser.getArray());



       MainWindowHandler mainWindowHandler = new MainWindowHandler();

    }
}
