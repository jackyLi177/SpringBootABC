package com.jacky.jwtdemo.dao;

import com.jacky.jwtdemo.bean.MyToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
public interface TokenDao extends JpaRepository<MyToken,Long> ,JpaSpecificationExecutor<MyToken> {
}
