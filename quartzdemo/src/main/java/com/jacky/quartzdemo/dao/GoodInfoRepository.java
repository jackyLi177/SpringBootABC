package com.jacky.quartzdemo.dao;

import com.jacky.quartzdemo.entity.GoodInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : liyongjie
 * @Date : 2018/10/23 0023
 */
public interface GoodInfoRepository
        extends JpaRepository<GoodInfoEntity,Long>
{
}
