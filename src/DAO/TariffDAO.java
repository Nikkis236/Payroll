package DAO;
import connector.DBConnector;
import model.Tariff;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TariffDAO {

    private  final DBConnector connector;


    public  TariffDAO(){
        connector= new DBConnector();

    }


    public List<Tariff> findAll() throws SQLException {

        String query ="SELECT * FROM tariff_scale;" ;
        ResultSet set= connector.dbExecuteQuery(query);
        return getListFromSet(set);

    }


    public void create(int category, double coefficient) throws SQLException {

        String query = "INSERT INTO tariff_scale(category,coefficient) " +
                "values ( "+category+", "+coefficient+");";

        connector.dbUpdate(query);

    }


    public void edit(int category, double coefficient) throws SQLException {
        int counter =0 ;

        String query ="UPDATE tariff_scale \n" ;
        if(coefficient!=0) {

            query+="SET coefficient = "+coefficient+"\n ";
        }


        query+= " WHERE category =" + category + ";" ;
        connector.dbUpdate(query);

    }


    public void delete(int category ) throws SQLException {
        String query ="DELETE FROM tariff_scale" +
                " WHERE category =" + category + ";" ;


        connector.dbUpdate(query);
    }

    private List<Tariff> getListFromSet(ResultSet set) throws SQLException {

        List<Tariff> tariffs = new ArrayList<>();


        while (set.next()){
            Tariff tariff =new Tariff();
            tariff.setCategory(set.getInt("category"));
            tariff.setCoefficient(set.getDouble("coefficient"));


            tariffs.add(tariff);
        }


        return tariffs;
    }


}