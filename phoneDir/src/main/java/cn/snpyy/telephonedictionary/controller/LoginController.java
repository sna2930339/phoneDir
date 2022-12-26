package cn.snpyy.telephonedictionary.controller;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cn.snpyy.telephonedictionary.service.LoginService;
import cn.snpyy.telephonedictionary.service.impl.LoginServiceImpl;
import java.io.IOException;

/**
 * @author 遂宁彭于晏
 */

@WebServlet({"/login","/exit","/register","/select","/modifypsw"})
public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String servletPath = request.getServletPath();
            if ("/login".equals(servletPath)){
                loginService.doLogin(request,response);
            }else if ("/exit".equals(servletPath)){
                loginService.doExit(request,response);
            }else if ("/register".equals(servletPath)){
                loginService.doUserRegister(request, response);
            }else if ("/select".equals(servletPath)){
                loginService.doSelect(request, response);
            }else if ("/modifypsw".equals(servletPath)){
                loginService.doModifyPsw(request, response);
            }
    }
}



