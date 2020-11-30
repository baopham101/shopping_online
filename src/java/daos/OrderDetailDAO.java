package daos;

import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    public void create(OrderDetailDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrderDetail(CreateDate, OrderID, CakeID) "
                        + " VALUES(?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setTimestamp(1, dto.getCreateDate());
                stm.setInt(2, dto.getOrderID());
                stm.setInt(3, dto.getCakeID());
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
}
