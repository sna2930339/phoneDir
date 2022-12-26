package cn.snpyy.telephonedictionary.service.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 遂宁彭于晏
 */
@WebFilter({"/list","/detail","/dispatchmodify","/domodify","/add","/delete"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session!=null && session.getAttribute("user")!=null) {
            chain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}


