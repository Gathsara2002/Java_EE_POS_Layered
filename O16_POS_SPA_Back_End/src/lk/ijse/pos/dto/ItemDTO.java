/**
 * @author : Gathsara
 * created : 9/16/2023 -- 11:53 AM
 **/

package lk.ijse.pos.dto;

public class ItemDTO {
    String code;
    String name;
    String qty;
    double price;

    public ItemDTO() {
    }

    public ItemDTO(String code, String name, String qty, double price) {
        this.code = code;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", price=" + price +
                '}';
    }
}
