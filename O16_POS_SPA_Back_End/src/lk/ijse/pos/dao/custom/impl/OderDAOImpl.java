/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:24 PM
 **/

package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<OrderEntity> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
