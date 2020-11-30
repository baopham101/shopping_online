/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author baoph
 */
public class DBUtils {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        InitialContext cnCtex = new InitialContext();
        DataSource src = (DataSource) cnCtex.lookup("java:comp/env/jdbc/Yellow");
        Connection conn = (Connection) src.getConnection();
        return conn;
    }
}
