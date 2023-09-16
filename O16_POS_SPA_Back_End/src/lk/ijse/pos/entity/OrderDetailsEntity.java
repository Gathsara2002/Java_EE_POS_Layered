/**
 * @author : Gathsara
 * created : 9/16/2023 -- 5:21 PM
 **/

package lk.ijse.pos.entity;

public class OrderDetailsEntity {
    String orderId;
    String itemCode;
    String qty;
    String unitPrice;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(String orderId, String itemCode, String qty, String unitPrice) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
