package cn.iruier.service;

import cn.iruier.entity.Contact;

public interface ContactService {
    boolean save(Contact contact);

    Contact queryByNo(String user_no);
}
