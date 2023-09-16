/**
 * @author : Gathsara
 * created : 9/15/2023 -- 9:11 PM
 **/

package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<CustomerEntity> getAll(Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("select * from Customer");
        ResultSet rst = pstm.executeQuery();

        ArrayList<CustomerEntity> cusEntity = new ArrayList<>();

        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String salary = rst.getString(4);
            cusEntity.add(new CustomerEntity(id, name, address, salary));
        }
        return cusEntity;
    }

    @Override
    public boolean save(CustomerEntity entity, Connection connection) throws SQLException, ClassNotFoundException {

        PreparedStatement pstm = connection.prepareStatement("insert into Customer values(?,?,?,?)");
        pstm.setObject(1, entity.getId());
        pstm.setObject(2, entity.getName());
        pstm.setObject(3, entity.getAddress());
        pstm.setObject(4, entity.getSalary());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(CustomerEntity entity, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = connection.prepareStatement("update Customer set name=?,address=?,salary=? where id=?");
        pstm.setObject(4, entity.getId());
        pstm.setObject(1, entity.getName());
        pstm.setObject(2, entity.getAddress());
        pstm.setObject(3, entity.getSalary());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }


}
