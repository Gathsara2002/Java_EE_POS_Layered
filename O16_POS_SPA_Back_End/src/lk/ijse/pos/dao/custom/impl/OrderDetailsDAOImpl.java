/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:27 PM
 **/

package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.entity.OrderDetailsEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<OrderDetailsEntity> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailsEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("insert into OrderDetails values(?,?,?,?)");
        pstm.setObject(1, entity.getOrderId());
        pstm.setObject(2, entity.getItemCode());
        pstm.setObject(3, entity.getQty());
        pstm.setObject(4, entity.getUnitPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(OrderDetailsEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
