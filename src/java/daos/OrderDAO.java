/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CakeDTO;
import dtos.OrderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

import utils.DBUtils;

/**
 * @author baoph
 */
public class OrderDAO {

    public void create(OrderDTO dto) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrder(OrderDate, PhoneNumber, Names, Addresss, PaymentMethod, PaymentStatus, Email) "
                        + " VALUES(?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setTimestamp(1, dto.getOrderDate());
                stm.setString(2, dto.getPhoneNumber());
                stm.setString(3, dto.getName());
                stm.setString(4, dto.getAddress());
                stm.setString(5, dto.getPaymentMethod());
                stm.setBoolean(6, dto.isPaymentStatus());
                stm.setString(7, dto.getEmail());
                stm.executeUpdate();

            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public List<OrderDTO> getOrderByID(int ID, String email) throws SQLException {
        List<OrderDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT OrderDate, PhoneNumber, Names, Addresss, PaymentMethod, PaymentStatus, Email " +
                        "FROM tblOrder " +
                        "WHERE OrderID = ? AND Email = ? ";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
                stm.setString(2, email);
                rs = stm.executeQuery();
                while (rs.next()) {
                    Timestamp orderDate = rs.getTimestamp("orderDate");
                    String phoneNumber = rs.getString("phoneNumber");
                    String name = rs.getString("names");
                    String address = rs.getString("addresss");
                    String paymentMethod = rs.getString("paymentMethod");
                    boolean paymentStatus = rs.getBoolean("paymentStatus");
                    result.add(new OrderDTO(ID, orderDate, phoneNumber, name, address, paymentMethod, email, paymentStatus));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<OrderDTO> getOrderByEmail(String email) throws SQLException {
        List<OrderDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT OrderID, OrderDate, PhoneNumber, Names, Addresss, PaymentMethod, PaymentStatus \n" +
                        "FROM tblOrder\n" +
                        "WHERE Email = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    Timestamp orderDate = rs.getTimestamp("orderDate");
                    String phoneNumber = rs.getString("phoneNumber");
                    String name = rs.getString("names");
                    String address = rs.getString("addresss");
                    String paymentMethod = rs.getString("paymentMethod");
                    boolean paymentStatus = rs.getBoolean("paymentStatus");
                    result.add(new OrderDTO(orderID, orderDate, phoneNumber, name, address, paymentMethod, email, paymentStatus));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public int getOrderID() throws SQLException {
        //List<BookDTO> result = new ArrayList<BookDTO>();
        OrderDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int ID = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT MAX(OrderID) AS ID FROM tblOrder";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    ID = rs.getInt("ID");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return ID;
    }

    public int getOrderIDByEmail(String email) throws SQLException {
        OrderDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int ID = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT MAX(OrderID)\n" +
                        "FROM tblOrder\n" +
                        "WHERE Email = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    ID = rs.getInt("orderID");
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return ID;
    }
}
