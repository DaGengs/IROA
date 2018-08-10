package cn.iruier.dao;

import cn.iruier.entity.Contact;

public interface ContactMapper {

    int save(Contact contact);

    Contact queryByNo(String user_no);
}
