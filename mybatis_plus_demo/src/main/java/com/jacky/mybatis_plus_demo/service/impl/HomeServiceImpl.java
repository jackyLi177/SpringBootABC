package com.jacky.mybatis_plus_demo.service.impl;

import com.jacky.mybatis_plus_demo.entity.Home;
import com.jacky.mybatis_plus_demo.dao.HomeMapper;
import com.jacky.mybatis_plus_demo.service.HomeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liyongjie
 * @since 2019-01-29
 */
@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, Home> implements HomeService {

}
