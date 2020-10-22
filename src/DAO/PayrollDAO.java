package DAO;


import connector.DBConnector;
import model.Payroll;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAO {

    private  final DBConnector connector;


    public  PayrollDAO(){
        connector= new DBConnector();

    }



    public List<Payroll> findAll() throws SQLException {

        String query ="SELECT * FROM staff_payment;" ;
        ResultSet set= connector.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    public List<Payroll> findMinPayroll(String month) throws SQLException {

        String query ="SELECT DISTINCT month, staff.last_name, staff.post, staff.id, accrued, withheld, to_payoff " +
                "FROM (SELECT * FROM staff_payment WHERE MONTH = '" + month + "') as st " +
                 "JOIN staff on staff.id = st.id " + "HAVING MIN(to_payoff);";

        ResultSet set= connector.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    public List<Payroll> findEmplMonthPayroll(String month, String lastName) throws SQLException {

        String query ="SELECT DISTINCT month, staff.last_name, staff.post, staff.id, accrued, withheld, to_payoff " +
                "FROM staff_payment " +
                "JOIN staff on staff.id = staff_payment.id " +
                "WHERE month = '" + month + "' and last_name = '" + lastName + "';";
        ResultSet set= connector.dbExecuteQuery(query);
        return getListFromSet(set);

    }


    public void updateDB(String month, String id, double accrued, double withheld, double toPayoff) throws SQLException {
        int counter =0 ;

        String query ="UPDATE staff_payment \n" ;
        if(accrued!=0) {
            counter++;
            query+="SET category = "+accrued+"\n ";
        }
        if(withheld != 0) {
            if(counter>0) query+=" , ";
            else query+=" SET ";
            counter++;
            query+= "  post = "+withheld+" \n";
        }
        if(toPayoff !=0)  {
            if(counter>0) query+=" , ";
            else query+=" SET ";
            query+= "  trade_union = "+toPayoff+" \n";}

        query+= " WHERE id ='" + id + "' and month ='" + month + "';" ;
        connector.dbUpdate(query);

    }



    private List<Payroll> getListFromSet(ResultSet set) throws SQLException {

        List<Payroll> payrolls = new ArrayList<>();



        while (set.next()){

            Payroll payroll =new Payroll();

            try {
                payroll.setMonth(set.getString("month"));
                payroll.setId(set.getString("id"));
                payroll.setAccruedAmount(set.getDouble("accrued"));
                payroll.setWithheldAmount(set.getDouble("withheld"));
                payroll.setAmountToPayoff(set.getDouble("to_payoff"));


                payroll.setLastName(set.getString("last_name"));
                payroll.setPost(set.getString("post"));
            }
            catch (SQLException throwables) {}

            payrolls.add(payroll);
        }


        return payrolls;
    }


}