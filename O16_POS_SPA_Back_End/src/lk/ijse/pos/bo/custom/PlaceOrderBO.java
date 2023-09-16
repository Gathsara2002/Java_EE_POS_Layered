/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:28 PM
 **/

package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
    ArrayList<OrderDTO> getAllOrders(Connection connection) throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO dto, Connection connection) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDetailsDTO> getAllOrderDetails(Connection connection) throws SQLException, ClassNotFoundException;

    boolean saveOrderDetail(OrderDetailsDTO dto, Connection connection) throws SQLException, ClassNotFoundException;

    boolean UpdateItemQty(int qty, String code, Connection connection) throws SQLException, ClassNotFoundException;

}
