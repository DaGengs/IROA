package cn.iruier.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.iruier.common.vo.AddressVo;
import cn.iruier.entity.Address;

public interface AddressService {
    public List<AddressVo> queryProvince();

    public List<AddressVo> queryCity(String pno);

    public List<AddressVo> queryCounty(String cno);

    boolean save(Address address);
}
