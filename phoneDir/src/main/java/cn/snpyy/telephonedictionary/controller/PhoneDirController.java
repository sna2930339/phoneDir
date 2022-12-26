package cn.snpyy.telephonedictionary.controller;

import cn.snpyy.telephonedictionary.service.PhoneDirService;
import cn.snpyy.telephonedictionary.service.impl.PhoneDirServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 遂宁彭于晏
 */

@WebServlet({"/list","/detail","/dispatchmodify","/domodify","/add","/delete","/dosearch","/searchAssociation"})
public class PhoneDirController extends HttpServlet {
    private PhoneDirService phoneDirService = new PhoneDirServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        if (session!=null && session.getAttribute("user")!=null) {
            if ("/list".equals(servletPath)) {
                phoneDirService.doList(request, response);
            } else if ("/add".equals(servletPath)) {
                phoneDirService.doAdd(request, response);
            } else if ("/delete".equals(servletPath)) {
                phoneDirService.doDelete(request, response);
            } else if ("/domodify".equals(servletPath)) {
                phoneDirService.doModify(request, response);
            } else if ("/detail".equals(servletPath.substring(0, 7))) {
                phoneDirService.doDetail(request, response, servletPath.substring(0, 7));
            } else if ("/dispatchmodify".equals(servletPath)) {
                phoneDirService.doDetail(request, response, servletPath.substring(9, 15));
            } else if ("/searchAssociation".equals(servletPath)){
                phoneDirService.searchAssociation(request, response);
            } else if ("/dosearch".equals(servletPath)){
                phoneDirService.doSearch(request, response);
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

}
