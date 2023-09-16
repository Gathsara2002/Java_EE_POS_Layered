/**
 * @author : Gathsara
 * created : 9/16/2023 -- 11:58 AM
 **/

package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.ItemEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemEntity> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("select * from item");
        ResultSet rst = pstm.executeQuery();

        ArrayList<ItemEntity> item = new ArrayList<>();

        while (rst.next()) {
            String code = rst.getString(1);
            String description = rst.getString(2);
            String qty = rst.getString(3);
            String unitPrice = rst.getString(4);

            item.add(new ItemEntity(code, description, qty, unitPrice));
        }

        return item;
    }

    @Override
    public boolean save(ItemEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("insert into item values(?,?,?,?)");
        pstm.setObject(1, entity.getCode());
        pstm.setObject(2, entity.getName());
        pstm.setObject(3, entity.getQty());
        pstm.setObject(4, entity.getPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(ItemEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("update item set name =?,qty=?,price=? where code=?");
        pstm.setObject(4, entity.getCode());
        pstm.setObject(1, entity.getName());
        pstm.setObject(2, entity.getQty());
        pstm.setObject(3, entity.getPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("delete from item where code=?");
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;

    }

    @Override
    public boolean updateItemQty(int qty, String code, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("update item set qty=? where code=?");
        pstm.setObject(2, code);
        pstm.setObject(1, qty);

        return pstm.executeUpdate() > 0;
    }
}
