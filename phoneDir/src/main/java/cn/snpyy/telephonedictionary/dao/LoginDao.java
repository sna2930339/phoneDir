package cn.snpyy.telephonedictionary.dao;

import cn.snpyy.telephonedictionary.bean.User;

/**
 * @author 遂宁彭于晏
 */

public interface LoginDao {

    boolean doLogin(User user);

    int doRegister(User user);

    int doSelect(String username);

    int doModifyPsw(User user);
}
