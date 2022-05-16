package com.haohao.security.mapper;

import com.haohao.security.domain.SecRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author haohao
 * @description 针对表【sec_role(角色表)】的数据库操作Mapper
 * @createDate 2022-05-16 15:07:15
 * @Entity com.haohao.security.domain.SecRole
 */
public interface SecRoleMapper extends BaseMapper<SecRole> {

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return List<SecRole>
     */
    List<SecRole> selectRoleListByUserId(Long userId);

}




