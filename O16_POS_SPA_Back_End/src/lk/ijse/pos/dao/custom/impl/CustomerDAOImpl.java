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
    public boolean save(CustomerEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
