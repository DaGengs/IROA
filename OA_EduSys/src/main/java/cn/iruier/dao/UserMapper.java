package cn.iruier.dao;

import cn.iruier.common.vo.MenuVo;
import cn.iruier.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import cn.iruier.entity.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
	/*@Select("select * from t_user and status = 1 and user_no = #{no}")
	@ResultType(User.class)
	public User queryByNo(String no);*/

    @Update("update t_user set user_password = #{new_password} where user_no = #{user_no}")
    int updatePwd(@Param("new_password") String new_password, @Param("user_no") String user_no);

    /*新增用户*/
    int save(User user);

    /*登录*/
    User queryByNo(String user_no);

    /*所有用户*/
    List<User> queryByPage(@Param("index") int index, @Param("size") int size);

    /*查询数量*/
    int queryCount();

    /*删除用户*/
    int deleteUser(int user_id);

    /*删除对应角色*/
    int deleteRole(int user_id);

    /*更新对应角色*/
    int updateRole(@Param("user_id") int user_id, @Param("role_id") int role_id);

    List<MenuVo> queryMenu(int user_id);

    List<Menu> queryChildMenu(@Param("menu_id") int menu_id);
}
