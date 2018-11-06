package com.mylearn.springbootlearn.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mylearn.springbootlearn.bean.User2;
import com.mylearn.springbootlearn.dao.User2Dao;
import com.mylearn.springbootlearn.dynamicconfig.TargetDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @date 2018/11/3 10:36
 * @Description:
 */
@Component
public class UserService {

  private Logger log = LoggerFactory.getLogger(UserService.class);



  public  void  log(){
    log.debug("user service debug");
    log.info("user service info");
    log.warn("user service warn");
    log.error("user service error");
  }

  @Autowired
  User2Dao user2Dao;
  public User2 getInfo(int ida){
    User2 user2= user2Dao.findByIdNum(ida);

    return user2;
  }

  @TargetDataSource(name="ds2")
  public Integer addUser(String name){
    User2 user2 = new User2();
    user2.setName(name);
     user2Dao.add(user2);

    return user2.getIda();
  }

  @Autowired
  JdbcTemplate jdbcTemplate;
  public Integer addUser2(String name){
//    jdbcTemplate.
    return jdbcTemplate.update("insert into user2(name) values(?)",
        name);
  }
public Integer addUser3(String name){
//    jdbcTemplate.
  final String sql = "insert into user2(name) values(?)";
  KeyHolder keyHolder = new GeneratedKeyHolder();
  jdbcTemplate.update(
      new PreparedStatementCreator() {
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException
        {
          PreparedStatement ps = jdbcTemplate.getDataSource()
              .getConnection().prepareStatement(sql,new String[]{ "NAME"});
          ps.setString(1, name);
          return ps;
        }
      }, keyHolder);
  return keyHolder.getKey().intValue();
}

  public List<Map> findAll(){
    //分页插件: 查询第1页，每页10行
    Page<User2> page = PageHelper.startPage(3, 1);

    List<Map> all = user2Dao.findAll();
    //数据表的总行数
    page.getTotal();
    //分页查询结果的总行数
    page.size();
    //第一个User对象，参考list，序号0是第一个元素，依此类推
    page.get(0);

    return all;
  }

}
