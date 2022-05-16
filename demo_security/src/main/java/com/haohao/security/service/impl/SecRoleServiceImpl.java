package com.haohao.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.security.domain.SecRole;
import com.haohao.security.service.SecRoleService;
import com.haohao.security.mapper.SecRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author haohao
* @description 针对表【sec_role(角色表)】的数据库操作Service实现
* @createDate 2022-05-16 15:07:15
*/
@Service
public class SecRoleServiceImpl extends ServiceImpl<SecRoleMapper, SecRole>
    implements SecRoleService{

}




