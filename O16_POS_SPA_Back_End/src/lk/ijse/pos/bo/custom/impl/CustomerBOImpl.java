/**
 * @author : Gathsara
 * created : 9/15/2023 -- 9:17 PM
 **/

package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException {

        ArrayList<CustomerDTO> allCustomers = new ArrayList();

        ArrayList<CustomerEntity> all = customerDAO.getAll(connection);
        for (CustomerEntity entity : all) {
            String id = entity.getId();
            String name = entity.getName();
            String address = entity.getAddress();
            String salary = entity.getSalary();
            allCustomers.add(new CustomerDTO(id, name, address, salary));
        }
        return allCustomers;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
