/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:24 PM
 **/

package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.OrderEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<OrderEntity> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("insert into Orders values(?,?,?)");
        pstm.setObject(1, entity.getOrderId());
        pstm.setObject(2, entity.getDate());
        pstm.setObject(3, entity.getCusId());

        return pstm.executeUpdate() > 0;
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
