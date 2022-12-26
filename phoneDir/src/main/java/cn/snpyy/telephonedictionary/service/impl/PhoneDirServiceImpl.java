package cn.snpyy.telephonedictionary.service.impl;

import cn.snpyy.telephonedictionary.bean.PhoneDir;
import cn.snpyy.telephonedictionary.dao.PhoneDirDao;
import cn.snpyy.telephonedictionary.service.PhoneDirService;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import cn.snpyy.telephonedictionary.dao.impl.PhoneDirDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 遂宁彭于晏
 */

public class PhoneDirServiceImpl implements PhoneDirService {
    private PhoneDirDao phoneDirDao = new PhoneDirDaoImpl();

    @Override
    public void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String master = String.valueOf(session.getAttribute("username"));
        List<PhoneDir> phoneDirList = phoneDirDao.doList(master);
        session.setAttribute("phoneDirList",phoneDirList);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    public void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contact = request.getParameter("contact");
        long number = Long.valueOf(request.getParameter("number"));
        String homeloc = request.getParameter("homeloc");
        String address = request.getParameter("address");

        String master = request.getSession().getAttribute("username").toString();
        PhoneDir phoneDir = new PhoneDir(master, contact, number, homeloc, address);

        int i = phoneDirDao.doAdd(phoneDir);
        if (i == 1){
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String id = request.getParameter("id");
        int i = phoneDirDao.deleteByDid(id);
        if (1 == i){
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }

    @Override
    public void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String contact = request.getParameter("contact");
        long number = Long.valueOf(request.getParameter("number"));
        String homeloc = request.getParameter("homeloc");
        String address = request.getParameter("address");

        String master = request.getSession().getAttribute("username").toString();
        int i = phoneDirDao.doModify(new PhoneDir(id,master, contact, number, homeloc, address));
        if (1 == i){
            response.sendRedirect(request.getContextPath() + "/list");
        }

    }

    @Override
    public void doDetail(HttpServletRequest request, HttpServletResponse response, String oa)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        PhoneDir phoneDir = phoneDirDao.doDetail(id);
        request.setAttribute("phoneDirDetail",phoneDir);
        request.getRequestDispatcher("/"+ oa +".jsp").forward(request,response);
    }

    @Override
    public void searchAssociation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String condition = request.getParameter("condition");
        String value = request.getParameter("value");
        PrintWriter out = response.getWriter();
        String master = request.getSession().getAttribute("username").toString();
        List<PhoneDir> list = phoneDirDao.searchAssociation(condition, value, master);
        String jsonStr = JSON.toJSONString(list);
        out.print(jsonStr);
    }

    @Override
    public void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String condition = request.getParameter("condition");
        String value = request.getParameter("value");
        PrintWriter out = response.getWriter();
        String master = request.getSession().getAttribute("username").toString();
        List<PhoneDir> list = phoneDirDao.doSearch(condition, value, master);
        String jsonStr = JSON.toJSONString(list);
        out.print(jsonStr);
    }
}







