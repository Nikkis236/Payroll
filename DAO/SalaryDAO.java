package DAO;

import connector.DBConnector;
import model.Salary;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO {

    private  final DBConnector connector;


    public  SalaryDAO(){
        connector= new DBConnector();

    }



    //найти  всех сотридников
    public List<Salary> findAll() throws SQLException {

        String query ="SELECT * FROM payment_amount;" ;
        ResultSet set= connector.dbExecuteQuery(query);
        return getListFromSet(set);

    }



    //обновление информации о сотруднике
    public void updateDB(String month,int minPayment) throws SQLException {
        int counter =0 ;

        String query ="UPDATE payment_amount \n" ;
        if(minPayment!=0) {

            query+="SET min_payment = "+minPayment+"\n ";
        }


        query+= " WHERE category ='" + month + "';" ;
        connector.dbUpdate(query);

    }



    private List<Salary> getListFromSet(ResultSet set) throws SQLException {

        List<Salary> salaries = new ArrayList<>();


        while (set.next()){
            Salary salary =new Salary();
            salary.setMonth(set.getString("month"));
            salary.setMinSalary(set.getInt("min_payment"));


            salaries.add(salary);
        }


        return salaries;
    }


}