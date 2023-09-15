/**
 * @author : Gathsara
 * created : 9/15/2023 -- 9:08 PM
 **/

package lk.ijse.pos.entity;

public class CustomerEntity {
    String id;
    String name;
    String address;
    String salary;

    public CustomerEntity() {
    }

    public CustomerEntity(String id, String name, String address, String salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
