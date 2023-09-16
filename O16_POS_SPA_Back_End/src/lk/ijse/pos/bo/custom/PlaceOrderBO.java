/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:28 PM
 **/

package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
    ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException;

    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDetailsDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException;

    boolean saveOrderDetail(OrderDetailsDTO dto) throws SQLException, ClassNotFoundException;

    boolean UpdateItemQty(int qty, String code) throws SQLException, ClassNotFoundException;

}
