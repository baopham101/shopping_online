/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.CakeDTO;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

import dtos.OrderDTO;
import utils.DBUtils;

/**
 * @author baoph
 */
public class CakeDAO {

    public void create(CakeDTO dto, InputStream image) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblMoonCakes(CakeName, Descriptions, Images, Price, Category, Quantity, CreateDate, ExpirationDate, Statuss) "
                        + " VALUES(?,?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setBinaryStream(3, image);
                stm.setFloat(4, dto.getPrice());
                stm.setString(5, dto.getCategory());
                stm.setInt(6, dto.getQuantity());
                stm.setDate(7, dto.getCreateDate());
                stm.setDate(8, dto.getExpirationDate());
                stm.setBoolean(9, dto.isStatus());
                stm.executeUpdate();

            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public List<CakeDTO> getAllListCakes(String search) throws SQLException {
        List<CakeDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT CakeID, CakeName, Descriptions, Images, Price, Category, Quantity, CreateDate, ExpirationDate, Statuss FROM tblMoonCakes "
                        + " WHERE CakeName LIKE ? AND Statuss = 'True' "
                        + " ORDER BY CreateDate DESC ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int cakeID = rs.getInt("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String description = rs.getString("descriptions");
                    byte[] img = rs.getBytes("images");
                    float price = rs.getFloat("price");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");
                    Date expirationDate = rs.getDate("expirationDate");
                    boolean status = rs.getBoolean("statuss");
                    result.add(new CakeDTO(cakeID, cakeName, description, category, img, price, quantity, createDate, expirationDate, status));
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

    public List<CakeDTO> getListCakeByID(int ID) throws SQLException {
        List<CakeDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT CakeName, Descriptions, Images, Price, Category, Quantity, CreateDate, ExpirationDate, Statuss FROM tblMoonCakes "
                        + " WHERE CakeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String cakeName = rs.getString("cakeName");
                    String description = rs.getString("descriptions");
                    byte[] img = rs.getBytes("images");
                    float price = rs.getFloat("price");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");
                    Date expirationDate = rs.getDate("expirationDate");
                    boolean status = rs.getBoolean("statuss");
                    result.add(new CakeDTO(ID, cakeName, description, category, img, price, quantity, createDate, expirationDate, status));
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

    public List<CakeDTO> getListCakeByCategory(String category) throws SQLException {
        List<CakeDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT CakeID, CakeName, Descriptions, Images, Price, Quantity, CreateDate, ExpirationDate, Statuss FROM tblMoonCakes "
                        + " WHERE Category = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, category);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int cakeID = rs.getInt("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String description = rs.getString("descriptions");
                    byte[] img = rs.getBytes("images");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");
                    Date expirationDate = rs.getDate("expirationDate");
                    boolean status = rs.getBoolean("statuss");
                    result.add(new CakeDTO(cakeID, cakeName, description, category, img, price, quantity, createDate, expirationDate, status));
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

    public void update(CakeDTO dto, InputStream image, int ID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE dbo.tblMoonCakes\n"
                        + "SET\n"
                        + "    CakeName = ?,\n"
                        + "    Descriptions = ?,\n"
                        + "    Images = ?,\n"
                        + "    Price = ?, \n"
                        + "    Category = ?,\n"
                        + "    Quantity = ?, \n"
                        + "    CreateDate = ?, \n"
                        + "    ExpirationDate = ?,\n"
                        + "    Statuss = ?\n"
                        + "	WHERE dbo.tblMoonCakes.CakeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setBinaryStream(3, image);
                stm.setFloat(4, dto.getPrice());
                stm.setString(5, dto.getCategory());
                stm.setInt(6, dto.getQuantity());
                stm.setDate(7, dto.getCreateDate());
                stm.setDate(8, dto.getExpirationDate());
                stm.setBoolean(9, dto.isStatus());
                stm.setInt(10, ID);
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

    public void delete(int ID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblMoonCakes\n"
                        + "SET Statuss = 0 \n"
                        + "WHERE CakeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
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

    public CakeDTO getCakeByID(int ID) throws SQLException {
        CakeDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT CakeName, Descriptions, Images, Price, Category, Quantity, CreateDate, ExpirationDate, Statuss FROM tblMoonCakes "
                        + " WHERE CakeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String cakeName = rs.getString("cakeName");
                    String description = rs.getString("descriptions");
                    byte[] img = rs.getBytes("images");
                    float price = rs.getFloat("price");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");
                    Date expirationDate = rs.getDate("expirationDate");
                    boolean status = rs.getBoolean("statuss");
                    dto = new CakeDTO(ID, cakeName, description, category, img, price, quantity, createDate, expirationDate, status);
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
        return dto;
    }

    public void updateQuantity(int cakeID, int quantity) throws SQLException {
        CakeDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblMoonCakes SET Quantity=? "
                        + " WHERE CakeID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setInt(2, cakeID);
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

    public int getQuantityByCakeID(int ID) throws SQLException {
        //List<BookDTO> result = new ArrayList<BookDTO>();
        CakeDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int quantity = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Quantity FROM tblMoonCakes "
                        + " WHERE CakeID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
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
        return quantity;
    }

    public List<CakeDTO> getCakeByOrderID(int ID) throws SQLException {
        List<CakeDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT tmc.CakeID, tmc.CakeName, tmc.Descriptions, tmc.Images, tmc.Price, tmc.Category, tmc.Quantity, tmc.CreateDate, tmc.ExpirationDate, tmc.Statuss\n" +
                        "FROM dbo.tblMoonCakes tmc JOIN \n" +
                        "(SELECT CakeID FROM dbo.tblOrderDetail WHERE dbo.tblOrderDetail.OrderID = ?) tod ON tod.CakeID = tmc.CakeID";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int cakeID = rs.getInt("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String description = rs.getString("descriptions");
                    byte[] img = rs.getBytes("images");
                    float price = rs.getFloat("price");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");
                    Date expirationDate = rs.getDate("expirationDate");
                    boolean status = rs.getBoolean("statuss");
                    result.add(new CakeDTO(cakeID, cakeName, description, category, img, price, quantity, createDate, expirationDate, status));
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

    public int count(String search) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT(CakeID) AS Total FROM tblMoonCakes WHERE CakeName LIKE ? ";
//                        + " WHERE ArticleID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1,"%" + search + "%");
                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt("total");
                }
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
        return 0;
    }

    public List<CakeDTO> getAllListCakeByPage(String search, int index, int size) throws SQLException {
        List<CakeDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "with x as (SELECT ROW_NUMBER() over (order by CreateDate DESC) AS rowNum, *\n" +
                        "FROM tblMoonCakes)\n" +
                        "SELECT * \n" +
                        "FROM x\n" +
                        "WHERE rowNum BETWEEN ?*20-19 AND ?*20 AND CakeName LIKE ? AND Statuss = 'True'";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, index);
                stm.setInt(2, index);
                stm.setString(3,"%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int cakeID = rs.getInt("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String description = rs.getString("descriptions");
                    byte[] img = rs.getBytes("images");
                    float price = rs.getFloat("price");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    Date createDate = rs.getDate("createDate");
                    Date expirationDate = rs.getDate("expirationDate");
                    boolean status = rs.getBoolean("statuss");
                    result.add(new CakeDTO(cakeID, cakeName, description, category, img, price, quantity, createDate, expirationDate, status));
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
}
