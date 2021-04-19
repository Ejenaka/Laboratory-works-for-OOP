package Lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T create(T entity);
    boolean update(T entity);
    boolean delete(int id);
    T findById(int id);
    List<T> getAll();

    default Connection getDefaultConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:E:/Student's life/ООП/mydatabase.db");
    }
}
