package lk.ijse.pos.servlet;


import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.servlet.util.ResponseUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    private final CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public CustomerServlet() {
        System.out.println("Customer Servlet Constructor Invoked");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");

      /*  try (Connection connection = dbcp.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("select * from Customer");
            ResultSet rst = pstm.executeQuery();

            JsonArrayBuilder allCustomers = Json.createArrayBuilder();
            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                String salary = rst.getString(4);

                JsonObjectBuilder customerObject = Json.createObjectBuilder();
                customerObject.add("id", id);
                customerObject.add("name", name);
                customerObject.add("address", address);
                customerObject.add("salary", salary);
                allCustomers.add(customerObject.build());
            }
            //create the response Object
            resp.getWriter().print(ResponseUtil.genJson("Success", "Loaded", allCustomers.build()));
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        }*/

        try (Connection connection = dbcp.getConnection()) {
            ArrayList<CustomerDTO> customers = customerBO.getAllCustomers(connection);

            JsonArrayBuilder allCustomers = Json.createArrayBuilder();

            for (CustomerDTO customer : customers) {
                String id = customer.getId();
                String name = customer.getName();
                String address = customer.getAddress();
                String salary = customer.getSalary();

                JsonObjectBuilder customerObject = Json.createObjectBuilder();
                customerObject.add("id", id);
                customerObject.add("name", name);
                customerObject.add("address", address);
                customerObject.add("salary", salary);
                allCustomers.add(customerObject.build());
            }

            resp.getWriter().print(ResponseUtil.genJson("Success", "Loaded", allCustomers.build()));

        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusID = req.getParameter("cusID");
        String cusName = req.getParameter("cusName");
        String cusAddress = req.getParameter("cusAddress");
        String cusSalary = req.getParameter("cusSalary");

        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");

        try (Connection connection = dbcp.getConnection()) {

           /* PreparedStatement pstm = connection.prepareStatement("insert into Customer values(?,?,?,?)");
            pstm.setObject(1, cusID);
            pstm.setObject(2, cusName);
            pstm.setObject(3, cusAddress);
            pstm.setObject(4, cusSalary);*/

            CustomerDTO customerDTO = new CustomerDTO(cusID, cusName, cusAddress, cusSalary);

            boolean isCustomerSaved = customerBO.saveCustomer(customerDTO, connection);

            if (isCustomerSaved) {
                resp.getWriter().print(ResponseUtil.genJson("Success", "Successfully Added.!"));
            }

        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String cusID = jsonObject.getString("id");
        String cusName = jsonObject.getString("name");
        String cusAddress = jsonObject.getString("address");
        String salary = jsonObject.getString("salary");

        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");

        try (Connection connection = dbcp.getConnection()) {

           /* PreparedStatement pstm = connection.prepareStatement("update Customer set name=?,address=?,salary=? where id=?");
            pstm.setObject(4, cusID);
            pstm.setObject(1, cusName);
            pstm.setObject(2, cusAddress);
            pstm.setObject(3, salary); */

            CustomerDTO customerDTO = new CustomerDTO(cusID, cusName, cusAddress, salary);

            boolean isCustomerUpdated = customerBO.updateCustomer(customerDTO, connection);
            if (isCustomerUpdated) {
                resp.getWriter().print(ResponseUtil.genJson("Success", "Customer Updated..!"));
            } else {
                resp.getWriter().print(ResponseUtil.genJson("Failed", "Customer Updated Failed..!"));
            }
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusID = req.getParameter("cusID");

        ServletContext servletContext = getServletContext();
        BasicDataSource dbcp = (BasicDataSource) servletContext.getAttribute("dbcp");

        try (Connection connection = dbcp.getConnection()) {

           /* PreparedStatement pstm = connection.prepareStatement("delete from Customer where id=?");
            pstm.setObject(1, cusID);*/

            boolean isCustomerDeleted = customerBO.deleteCustomer(cusID, connection);

            if (isCustomerDeleted) {
                resp.getWriter().print(ResponseUtil.genJson("Success", "Customer Deleted..!"));
            } else {
                resp.getWriter().print(ResponseUtil.genJson("Failed", "Customer Delete Failed..!"));
            }
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.genJson("Error", e.getMessage()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
