package com.haohao.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haohao.mybatis.plus.domain.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author haohao
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
}
