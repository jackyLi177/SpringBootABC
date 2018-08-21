package com.jacky.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Cacheable(value = "emp")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    @CachePut(value = "saveEmp")
    public Employee save(Employee employee){
        return employeeDao.save(employee);
    }

}
