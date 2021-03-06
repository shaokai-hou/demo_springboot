package com.haohao.mybatis.plus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.mybatis.plus.domain.SysUserEntity;
import com.haohao.mybatis.plus.mapper.SysUserMapper;
import com.haohao.mybatis.plus.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * @author haohao
 */
@Service
@DS("slave")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {
}
