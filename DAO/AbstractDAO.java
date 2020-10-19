package DAO;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO <T> {

    public abstract List<T> findAll() throws SQLException;

    public abstract void create();

    public abstract void delete();

    public abstract void update();

}
