/**
 * @author : Gathsara
 * created : 9/16/2023 -- 11:58 AM
 **/

package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.ItemEntity;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<ItemEntity> {

    boolean updateItemQty(int qty, String code, Connection connection) throws SQLException, ClassNotFoundException;
}
