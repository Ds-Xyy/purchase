package com.turing.purchase.mapper;

import com.turing.purchase.entity.SysUsers;
import com.turing.purchase.entity.SysUsersExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUsersMapper {
    int countByExample(SysUsersExample example);

    int deleteByExample(SysUsersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersExample example);

    SysUsers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByExample(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

    /**
     * 添加用户
     * @param user 用户对象
     */
    @Insert("insert into sys_users values(#{id},#{userName},#{passWord},#{salt})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void addUser(SysUsers user);


    //根据用户名查询用户信息
    @Select("select * from sys_users where user_name=#{userName}")
    SysUsers findByName(@Param("userName") String userName);
}