package com.haohao.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.security.domain.SecPermission;
import com.haohao.security.service.SecPermissionService;
import com.haohao.security.mapper.SecPermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author haohao
* @description 针对表【sec_permission(权限表)】的数据库操作Service实现
* @createDate 2022-05-16 15:07:15
*/
@Service
public class SecPermissionServiceImpl extends ServiceImpl<SecPermissionMapper, SecPermission>
    implements SecPermissionService {

}




