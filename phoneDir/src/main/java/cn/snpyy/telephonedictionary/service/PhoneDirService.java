package cn.snpyy.telephonedictionary.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 遂宁彭于晏
 */

public interface PhoneDirService {
    void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * 一条信息记录查询通用方法
     * @param request
     * @param response
     * @param oa 功能的名字 (比如修改modify 和 详细detail 的信息都只需查询一条)
     * @author snpyy
     */
    void doDetail(HttpServletRequest request, HttpServletResponse response, String oa) throws ServletException, IOException;

    /**
     * 模糊查询
     * @param request
     * @param response
     */
    void searchAssociation(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
