package com.guoer.privilege.convert;

import com.guoer.privilege.entity.Role;
import com.guoer.privilege.repostory.po.RolePO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 21:01
 * @description：Role对象转换器
 * @version: 1.0.0
 */
@Mapper
public interface RoleConvert {

    @Mappings({
            @Mapping(source = "status.status", target = "status")
    })
    RolePO toPO(Role role);
}
