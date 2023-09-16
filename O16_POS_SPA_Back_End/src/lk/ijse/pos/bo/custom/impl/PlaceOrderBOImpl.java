/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:29 PM
 **/

package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.PlaceOrderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailsDTO;
import lk.ijse.pos.entity.OrderDetailsEntity;
import lk.ijse.pos.entity.OrderEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<OrderDTO> getAllOrders(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveOrder(OrderDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        OrderEntity entity = new OrderEntity(dto.getOrderId(), dto.getDate(), dto.getCusId());
        return orderDAO.save(entity, connection);
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails(Connection connection) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailsDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        OrderDetailsEntity entity = new OrderDetailsEntity(dto.getOrderId(), dto.getItemCode(), dto.getQty(), dto.getUnitPrice());
        return orderDetailsDAO.save(entity, connection);
    }

    @Override
    public boolean UpdateItemQty(int qty, String code, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
