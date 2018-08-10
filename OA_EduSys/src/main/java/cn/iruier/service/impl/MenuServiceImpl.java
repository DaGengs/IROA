package cn.iruier.service.impl;

import cn.iruier.common.vo.PageVo;
import cn.iruier.common.vo.ResultVo;
import cn.iruier.dao.MenuMapper;
import cn.iruier.entity.Menu;
import cn.iruier.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;

    @Override
    public ResultVo save(Menu menu) {
        if (mapper.save(menu) > 0) {
            return ResultVo.setOK("新增成功");
        } else {
            return ResultVo.setERROR("新增失败");
        }
    }

    @Override
    public ResultVo deleteMenu(int menu_id) {
        if (mapper.deleteMenu(menu_id) > 0) {
            return ResultVo.setOK("删除成功");
        } else {
            return ResultVo.setERROR("删除失败");
        }
    }

    @Override
    public ResultVo updateMenu(Menu menu) {
        if (mapper.updateMenu(menu) > 0) {
            return ResultVo.setOK("修改成功");
        } else {
            return ResultVo.setERROR("修改失败");
        }
    }

    @Override
    public PageVo<Menu> queryByPage(int page, int size) {
        PageVo<Menu> pageVo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * size;
        }
        List<Menu> menus = mapper.queryByPage(index, size);
        if (menus != null) {
            pageVo.setCode(0);
            pageVo.setCount(mapper.queryCount());
            pageVo.setMsg("");
            pageVo.setData(menus);
        } else {
            pageVo.setCode(1);
            pageVo.setCount(0);
            pageVo.setMsg("暂无数据");
            pageVo.setData(new ArrayList<>());
        }
        return pageVo;
    }

    @Override
    public List<Menu> queryAll() {
        return mapper.queryAll();
    }
}
