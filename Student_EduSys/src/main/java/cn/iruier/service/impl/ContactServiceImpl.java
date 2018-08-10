package cn.iruier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.dao.ContactMapper;
import cn.iruier.entity.Contact;
import cn.iruier.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper mapper;

    @Override
    public boolean save(Contact contact) {
        return mapper.save(contact) > 0;
    }

    @Override
    public Contact queryByNo(String user_no) {
        if (StringUtils.empty(user_no)) {
            return mapper.queryByNo(user_no);
        }
        return null;
    }


}
