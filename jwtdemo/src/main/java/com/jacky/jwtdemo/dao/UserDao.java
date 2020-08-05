package com.jacky.jwtdemo.dao;

import com.jacky.jwtdemo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : lyj
 * @Date : 2018/8/21 0021
 */
@Repository
public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

}
