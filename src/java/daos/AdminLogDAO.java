package daos;

import dtos.AdminLogDTO;
import dtos.CakeDTO;
import dtos.OrderDTO;
import utils.DBUtils;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminLogDAO {
    public void create(AdminLogDTO dto) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO dbo.tblAdminLog\n" +
                        "(\n" +
                        "    --LogID - column value is auto-generated\n" +
                        "    Email,\n" +
                        "    Actions,\n" +
                        "    UpdateDate\n" +
                        ")\n" +
                        "VALUES\n" +
                        "(\n" +
                        "    -- LogID - int\n" +
                        "    ?, -- Email - nvarchar\n" +
                        "    ?, -- Actions - nvarchar\n" +
                        "    ? -- UpdateDate - datetime\n" +
                        ")";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getAction());
                stm.setTimestamp(3, dto.getLogDate());
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

    public List<AdminLogDTO> getAllListLog() throws SQLException {
        List<AdminLogDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT LogID, Email, Actions, UpdateDate\n" +
                        "FROM tblAdminLog\n" +
                        "ORDER BY UpdateDate DESC";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int logID = rs.getInt("logID");
                    String email = rs.getString("email");
                    String action = rs.getString("actions");
                    Timestamp updateDate = rs.getTimestamp("updateDate");
                    result.add(new AdminLogDTO(logID, email, action, updateDate));
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
