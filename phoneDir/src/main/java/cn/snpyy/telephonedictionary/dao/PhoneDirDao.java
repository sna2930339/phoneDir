package cn.snpyy.telephonedictionary.dao;

import cn.snpyy.telephonedictionary.bean.PhoneDir;

import java.util.List;

/**
 * @author 遂宁彭于晏
 */

public interface PhoneDirDao {
    int deleteByDid(String id);

    int doAdd(PhoneDir dept);

    List<PhoneDir> doList(String username);

    PhoneDir doDetail(String id);

    int doModify(PhoneDir phoneDir);

    List<PhoneDir> searchAssociation(String condition, String pram, String master);

    List<PhoneDir> doSearch(String condition, String pram, String master);

}
