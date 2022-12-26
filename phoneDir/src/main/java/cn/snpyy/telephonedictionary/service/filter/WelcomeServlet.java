package cn.snpyy.telephonedictionary.service.filter;

import cn.snpyy.telephonedictionary.bean.User;
import cn.snpyy.telephonedictionary.util.DBUtils;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 遂宁彭于晏
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String passwrod = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name)){
                    username = cookie.getValue();
                }else if ("password".equals(name)){
                    passwrod = cookie.getValue();
                }
            }
        }
        if (username != null && passwrod != null){
            //进入网站 跳转验证cookie储存的username和password  然后直接进入登录成功页面
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            boolean flag = false;
            try {
                conn = DBUtils.getConnection();
                String sql = "select * from t_user where username=? and password=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,passwrod);
                rs = ps.executeQuery();
                if (rs.next()){
                    //登录成功
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtils.release(conn,ps,rs);
            }
            if (flag){
               HttpSession session = request.getSession();
                //session.setAttribute("user",username);

                User user1 = new User(username, passwrod);
                session.setAttribute("user",user1);
                //登录人数统计
                ServletContext application = request.getServletContext();
                Object onlineCount = application.getAttribute("onlineCount");
                if (onlineCount == null){
                    application.setAttribute("onlineCount",1);
                }else{
                    int count = (int)onlineCount;
                    count++;
                    application.setAttribute("onlineCount",count);
                }
                response.sendRedirect(request.getContextPath()+"/list");
            }else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }else{
            //跳转至登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }


    }
}
