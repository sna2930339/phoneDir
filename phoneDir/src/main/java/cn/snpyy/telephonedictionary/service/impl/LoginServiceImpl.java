package cn.snpyy.telephonedictionary.service.impl;

import cn.snpyy.telephonedictionary.bean.User;
import cn.snpyy.telephonedictionary.dao.LoginDao;
import cn.snpyy.telephonedictionary.dao.impl.LoginDaoImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import cn.snpyy.telephonedictionary.service.LoginService;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 遂宁彭于晏
 */

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao = new LoginDaoImpl();

    @Override
    public void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            if(cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setValue(null);//退出登录后  三天免登录就失效了
                    response.addCookie(cookie);
                    cookie.setPath("6");
                    cookie.setMaxAge(0);
                }
            }
            ServletContext application = request.getServletContext();

            int onlineCount = (int)application.getAttribute("onlineCount");
            onlineCount--;
            application.setAttribute("onlineCount",onlineCount);

            response.sendRedirect(request.getContextPath()+ "/index.jsp");
        }
    }

    @Override
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("user");
        String psw = request.getParameter("psw");
        boolean login;
        login = loginDao.doLogin(new User(username, psw));
        if (login){
            HttpSession session = request.getSession();
            User user1 = new User(username, psw);
            session.setAttribute("user",user1);
            //登录者姓名提交到Session域中
            session.setAttribute("username",username);
            String f = request.getParameter("f");
            if ("1".equals(f)){
                //把用户登录信息存到cookie
                Cookie cookie1 = new Cookie("username",username);
                Cookie cookie2 = new Cookie("password",psw);
                //设置cookie有效时间
                cookie1.setMaxAge( 60 * 60 * 24 * 3);
                cookie2.setMaxAge( 60 * 60 * 24 * 3);
                //设置cookie的path(只要访问这个项目，都携带cookie)
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                //响应cookie给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
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
            response.sendRedirect(request.getContextPath() + "/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.html");
        }

    }

    @Override
    public void doUserRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int i = loginDao.doRegister(new User(username, password));

        if (1 == i) {
            response.sendRedirect(request.getContextPath() + "/list");
        }else {
            out.print("注册失败，请返回重新注册");
        }
    }

    @Override
    public void doSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        int i = loginDao.doSelect(username);
        if (i > 0){
            out.print(1);
        }else {
            out.print(0);
        }
    }

    @Override
    public void doModifyPsw(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newPsw = request.getParameter("newpsw");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(newPsw);
        int i = loginDao.doModifyPsw(user);
        if (1 == i) {
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath() + "/list");
        }else {
            response.sendRedirect(request.getContextPath() + "/modifypsw.jsp");
        }

    }
}














