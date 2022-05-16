package com.haohao.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.security.domain.SecUserRole;
import com.haohao.security.service.SecUserRoleService;
import com.haohao.security.mapper.SecUserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author haohao
* @description 针对表【sec_user_role(用户角色关系表)】的数据库操作Service实现
* @createDate 2022-05-16 15:07:15
*/
@Service
public class SecUserRoleServiceImpl extends ServiceImpl<SecUserRoleMapper, SecUserRole>
    implements SecUserRoleService {

}




