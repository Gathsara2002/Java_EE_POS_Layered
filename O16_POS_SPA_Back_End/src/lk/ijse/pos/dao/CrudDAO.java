/**
 * @author : Gathsara
 * created : 9/15/2023 -- 9:04 PM
 **/

package lk.ijse.pos.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    ArrayList<T> getAll(Connection connection) throws SQLException, ClassNotFoundException;

    boolean save(T entity, Connection connection) throws SQLException, ClassNotFoundException;

    boolean update(T entity, Connection connection) throws SQLException, ClassNotFoundException;

    boolean delete(String id, Connection connection) throws SQLException, ClassNotFoundException;
}
