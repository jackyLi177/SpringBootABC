package com.jacky.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
