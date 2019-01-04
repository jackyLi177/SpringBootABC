package com.jacky.mybatis_plus_demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jacky.mybatis_plus_demo.entity.User;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2019-01-04
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
