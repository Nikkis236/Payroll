package DAO;


import connector.DBConnector;
import model.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private  final DBConnector connector;


    public  EmployeeDAO(){
        connector= new DBConnector();

    }



    public List<Employee> findAll() throws SQLException {

        String query ="SELECT * FROM staff;" ;
        ResultSet set= connector.dbExecuteQuery(query);
        return getListFromSet(set);

    }

    public void create(String id, String lastName, int category, String post, boolean tradeUnion) throws SQLException {

        String query = "INSERT INTO staff(id,last_name,category,post,trade_union) " +
                "values ( '"+id+"', '"+lastName+"',"+category+", '"+post+"', "+tradeUnion+");";

        connector.dbUpdate(query);

    }


    public void edit(String id, String lastName,  int category, String post, Boolean tradeUnion) throws SQLException {
        int counter =0 ;

        String query ="UPDATE staff \n" ;
        if(category!=0) {
            counter++;
            query+="SET category = "+category+"\n ";
        }
        if(post != null) {
            if(counter>0) query+=" , ";
            else query+=" SET ";
            counter++;
            query+= "  post = '"+post+"' \n";
        }
        if(lastName != null) {
            if(counter>0) query+=" , ";
            else query+=" SET ";
            counter++;
            query+= "  last_name = '"+lastName+"' \n";
        }
        if(tradeUnion != null)  {
            if(counter>0) query+=" , ";
            else query+=" SET ";
            query+= "  trade_union = "+tradeUnion+" \n";}

        query+= " WHERE id ='" + id + "';" ;
        connector.dbUpdate(query);

    }


    public void delete(String id ) throws SQLException {
        String query ="DELETE FROM staff" +
                " WHERE id ='" + id + "';" ;


        connector.dbUpdate(query);
    }

    private List<Employee> getListFromSet(ResultSet set) throws SQLException {

        List<Employee> employees = new ArrayList<>();


        while (set.next()){
            Employee employee =new Employee();
            employee.setCategory(set.getInt("category"));
            employee.setId(set.getString("id"));
            employee.setLastName(set.getString("last_name"));
            employee.setPost(set.getString("post"));
            employee.setTradeUnion(set.getBoolean("trade_union"));



            employees.add(employee);
        }


        return employees;
    }


}