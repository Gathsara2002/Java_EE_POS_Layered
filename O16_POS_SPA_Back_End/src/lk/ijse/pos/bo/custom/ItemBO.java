/**
 * @author : Gathsara
 * created : 9/16/2023 -- 12:01 PM
 **/

package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id, Connection connection) throws SQLException, ClassNotFoundException;
}
