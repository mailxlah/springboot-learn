package com.mylearn.springbootlearn.dao;


import com.mylearn.springbootlearn.bean.UserDO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户服务数据接口类
 *
 * @author 杨高超
 * @since 2018-03-12
 */



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户服务数据接口类
 *
 * @author 杨高超
 * @since 2018-03-12
 */

@Repository
public interface UserDaoJpa extends JpaRepository<UserDO, Long> {

  Optional<UserDO> findById(long l);

}
