package cn.snpyy.telephonedictionary.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 遂宁彭于晏
 */

public interface LoginService {
    void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void doUserRegister(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void doSelect(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void doModifyPsw(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
