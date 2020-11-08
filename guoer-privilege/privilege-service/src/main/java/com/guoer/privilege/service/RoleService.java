package com.guoer.privilege.service;

import com.guoer.privilege.convert.RoleConvert;
import com.guoer.privilege.entity.Role;
import com.guoer.privilege.repostory.RoleRepostory;
import com.guoer.privilege.repostory.po.RolePO;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:20
 * @description：角色服务实现
 * @modified By：
 * @version: 1.0.0
 */
@Service
public class RoleService {

    @Resource
    private RoleRepostory roleRepostory;

    private RoleConvert roleConvert= Mappers.getMapper(RoleConvert.class);

    //@GlobalTransactional(rollbackFor = Exception.class) TODO 跨服务调用 需要开启全局事务控制
    public boolean create(Role role) {
        RolePO rolePO = roleConvert.toPO(role);
        Boolean r = roleRepostory.save(rolePO);
        return r;
    }

}
