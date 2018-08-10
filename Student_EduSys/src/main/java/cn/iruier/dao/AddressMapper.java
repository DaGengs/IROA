package cn.iruier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.iruier.common.vo.AddressVo;
import cn.iruier.entity.Address;

public interface AddressMapper {
    public List<AddressVo> queryProvince();

    public List<AddressVo> queryCity(@Param("pno") String pno);

    public List<AddressVo> queryCounty(@Param("cno") String cno);

    int save(Address address);
}
