package com.haohao.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.security.domain.SecRolePermission;
import com.haohao.security.service.SecRolePermissionService;
import com.haohao.security.mapper.SecRolePermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author haohao
* @description 针对表【sec_role_permission(角色权限关系表)】的数据库操作Service实现
* @createDate 2022-05-16 15:07:15
*/
@Service
public class SecRolePermissionServiceImpl extends ServiceImpl<SecRolePermissionMapper, SecRolePermission>
    implements SecRolePermissionService{

}




