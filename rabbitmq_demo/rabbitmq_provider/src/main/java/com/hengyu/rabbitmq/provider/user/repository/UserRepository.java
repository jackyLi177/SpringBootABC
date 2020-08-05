package com.hengyu.rabbitmq.provider.user.repository;

import com.hengyu.rabbitmq.provider.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据接口定义
 * ========================
 */
public interface UserRepository
    extends JpaRepository<UserEntity,Long>
{
}
