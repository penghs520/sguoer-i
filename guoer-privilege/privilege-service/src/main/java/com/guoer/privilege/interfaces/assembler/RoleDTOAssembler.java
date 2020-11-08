package com.guoer.privilege.interfaces.assembler;

import com.guoer.privilege.dto.RoleDTO;
import com.guoer.privilege.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:47
 * @description：RoleDTO对象转换器
 * @version: 1.0.0
 */
@Mapper
public interface RoleDTOAssembler {

    @Mappings({
            @Mapping(source = "status", target = "status.status"),//相同属性的不需要配置映射
    })
    Role toRoleEntity(RoleDTO dto);

}
