package cn.snpyy.telephonedictionary.dao.impl;


import cn.snpyy.telephonedictionary.bean.PhoneDir;
import cn.snpyy.telephonedictionary.dao.PhoneDirDao;
import cn.snpyy.telephonedictionary.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 遂宁彭于晏
 */

public class PhoneDirDaoImpl implements PhoneDirDao {
    @Override
    public int deleteByDid(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = DBUtils.getConnection();
            String sql = "delete from t_phonedir where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            num = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return num;
    }

    @Override
    public int doAdd(PhoneDir phoneDir) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = DBUtils.getConnection();
            String sql = "insert into t_phonedir(master,contact,number,homeloc,address) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, phoneDir.getMaster());
            ps.setString(2, phoneDir.getContact());
            ps.setLong(3,phoneDir.getNumber());
            ps.setString(4, phoneDir.getHomeLoc());
            ps.setString(5, phoneDir.getAddress());

            num = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return num;
    }

    @Override
    public List<PhoneDir> doList(String username) {
        //连接数据库  然后转发 响应网页  动态获取数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PhoneDir> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from t_phonedir where master = ? ";

            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = Integer.parseInt(rs.getString("id"));
                String master = rs.getString("master");
                String homeloc = rs.getString("homeloc");
                long number = Long.parseLong(rs.getString("number"));
                String address = rs.getString("address");
                String contact = rs.getString("contact");

                list.add(new PhoneDir(id,master,contact,number,homeloc,address));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return list;
    }

    @Override
    public PhoneDir doDetail(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PhoneDir phoneDir =  null;
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from t_phonedir where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                String master = rs.getString("master");
                String homeLoc = rs.getString("homeloc");
                long phoneNumber = Long.parseLong(rs.getString("number"));
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                phoneDir = new PhoneDir(Integer.parseInt(id),master,contact,phoneNumber,homeLoc,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DBUtils.release(conn,ps,rs);
        }
        return phoneDir;
    }

    @Override
    public int doModify(PhoneDir phoneDir) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = DBUtils.getConnection();
            String sql = "update t_phonedir set homeloc=?,number=?,address=?,contact=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, phoneDir.getHomeLoc());
            ps.setLong(2,phoneDir.getNumber());
            ps.setString(3, phoneDir.getAddress());
            ps.setString(4, phoneDir.getContact());
            ps.setInt(5,phoneDir.getId());
            num = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn,ps,rs);
        }
        return num;
    }

    @Override
    public List<PhoneDir> searchAssociation(String condition, String pram,String master) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        if ("number".equals(condition)){
            sql = "select * from t_phonedir where master = '"+master+"' and number like '%"+pram+"%'";
        }else if ("homeLoc".equals(condition)){
            sql = "select * from t_phonedir where master = '"+master+"' and homeloc like '%"+pram+"%'";
        }
        List<PhoneDir> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String homeloc = rs.getString("homeloc");
                long number = Long.parseLong(rs.getString("number"));
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                list.add(new PhoneDir(id,master,contact,number,homeloc,address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<PhoneDir> doSearch(String condition, String pram, String master) {
        return searchAssociation(condition, pram, master);
    }


}
