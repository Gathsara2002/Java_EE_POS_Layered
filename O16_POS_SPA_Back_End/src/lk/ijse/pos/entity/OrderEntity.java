/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:18 PM
 **/

package lk.ijse.pos.entity;

public class OrderEntity {
    String orderId;
    String Date;
    String cusId;

    public OrderEntity() {
    }

    public OrderEntity(String orderId, String date, String cusId) {
        this.orderId = orderId;
        Date = date;
        this.cusId = cusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
}
