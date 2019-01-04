package com.jacky.mybatis_plus_demo.service.impl;

import com.jacky.mybatis_plus_demo.entity.User;
import com.jacky.mybatis_plus_demo.dao.UserMapper;
import com.jacky.mybatis_plus_demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2019-01-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
