package com.mylearn.springbootlearn.dao;

import com.mylearn.springbootlearn.bean.User2;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @date 2018/11/3 0:33
 * @Description:
 */
@Mapper
public interface User2Dao {
  @Select("select * from user2 where ida = #{ida}")
  public List<User2> findById(User2 param);
//  public User2 findById(User2 param);

  @Select("select * from user2 where ida = #{ida}")
  public User2 findByIdNum(int ida);

  @Insert("insert into user2(name) values(#{name})")
  @Options(useGeneratedKeys=true,keyProperty="ida")
  public int add(User2 param);

//  @Results({
//      @Result(property="nickName",column="nick_name")
//  })
  @Select("select * from user2")
  public List<Map> findAll();
}
