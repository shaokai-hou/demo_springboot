package com.haohao.security.mapper;

import com.haohao.security.domain.SecPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author haohao
 * @description 针对表【sec_permission(权限表)】的数据库操作Mapper
 * @createDate 2022-05-16 15:07:15
 * @Entity com.haohao.security.domain.SecPermission
 */
public interface SecPermissionMapper extends BaseMapper<SecPermission> {

    /**
     * 根据角色Ids查询权限
     *
     * @param roleId 角色Ids
     * @return 权限集合
     */
    List<SecPermission> selectPermissionListByRoleIds(@Param("roleId") List<Long> roleId);
}




