/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author baoph
 */
public class UserDAO {
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblUsers "
                        + "WHERE Email= " + "'" + userID + "'" + " AND Passwords = " + "'" + password + "'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new UserDTO(rs.getString("Email"), rs.getString("Names"), "", rs.getString("RoleName"));
                }
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {
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
    
    public void create(UserDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUsers(Email, Names, Passwords, RoleName) "
                        + " VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getName());
                stm.setString(3, dto.getPassword());
                stm.setString(4, dto.getRole());
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
    
    public boolean checkID(String Email) throws SQLException {
        boolean result = true;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Names FROM tblUsers "
                        + "WHERE Email= " + "'" + Email + "'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = false;
                }
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {
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
