package cn.snpyy.telephonedictionary.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 *  连接数据库工具类
 * @author 遂宁彭于晏
 */

public class DBUtils {
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    static String driver = resourceBundle.getString("driver");
    static String url = resourceBundle.getString("url");
    static String user = resourceBundle.getString("user");
    static String psw = resourceBundle.getString("psw");

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,psw);
    }

    public static void release(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
