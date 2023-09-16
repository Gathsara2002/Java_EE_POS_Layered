/**
 * @author : Gathsara
 * created : 9/16/2023 -- 12:01 PM
 **/

package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.ItemEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public ArrayList<ItemDTO> getAllItems(Connection connection) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();

        ArrayList<ItemEntity> all = itemDAO.getAll(connection);
        for (ItemEntity item : all) {
            String code = item.getCode();
            String name = item.getName();
            String qty = item.getQty();
            String price = item.getPrice();

            allItems.add(new ItemDTO(code, name, qty, price));
        }

        return allItems;
    }

    @Override
    public boolean saveItem(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        ItemEntity entity = new ItemEntity(dto.getCode(), dto.getName(), dto.getQty(), dto.getPrice());
        return itemDAO.save(entity, connection);
    }

    @Override
    public boolean updateItem(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        ItemEntity entity = new ItemEntity(dto.getCode(), dto.getName(), dto.getQty(), dto.getPrice());
        return itemDAO.update(entity,connection);
    }

    @Override
    public boolean deleteItem(String id, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
