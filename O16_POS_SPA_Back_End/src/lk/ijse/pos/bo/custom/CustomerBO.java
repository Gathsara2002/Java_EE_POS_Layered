/**
 * @author : Gathsara
 * created : 9/15/2023 -- 9:16 PM
 **/

package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    ArrayList<CustomerDTO> getAllCustomers(Connection connection) throws SQLException, ClassNotFoundException;

    boolean saveCustomer(CustomerDTO dto,Connection connection) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO dto,Connection connection) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
}
