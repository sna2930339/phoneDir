package cn.snpyy.telephonedictionary.dao.impl;

import cn.snpyy.telephonedictionary.bean.User;
import cn.snpyy.telephonedictionary.dao.LoginDao;
import cn.snpyy.telephonedictionary.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 遂宁彭于晏
 */

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean doLogin(User user) {
        boolean Login = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()){
                //进来了说明查询到了登录结果   则表示登录成功
                Login = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return Login;
    }

    @Override
    public int doRegister(User user) {
        int num = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "insert into t_user(username,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2, user.getPassword());
            num = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return num;
    }

    @Override
    public int doSelect(String username) {
        int num = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "select * from t_user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){num+=1;}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return num;
    }

    @Override
    public int doModifyPsw(User user){
        int num = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "update t_user set password = ? where username =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            num = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return num;
    }
}
