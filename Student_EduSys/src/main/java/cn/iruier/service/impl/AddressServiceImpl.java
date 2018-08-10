package cn.iruier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.iruier.common.utils.StringUtils;
import cn.iruier.common.vo.AddressVo;
import cn.iruier.dao.AddressMapper;
import cn.iruier.entity.Address;
import cn.iruier.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper mapper;

    @Override
    public List<AddressVo> queryProvince() {
        return mapper.queryProvince();
    }

    @Override
    public List<AddressVo> queryCity(String pno) {
        if (StringUtils.empty(pno)) {
            return mapper.queryCity(pno);
        }
        return null;
    }

    @Override
    public List<AddressVo> queryCounty(String cno) {
        if (StringUtils.empty(cno)) {
            return mapper.queryCounty(cno);
        }
        return null;
    }

    @Override
    public boolean save(Address address) {
        return mapper.save(address) > 0;
    }

}
