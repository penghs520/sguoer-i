package com.guoer.privilege.interfaces;

import com.guoer.common.response.R;
import com.guoer.privilege.dto.RoleDTO;
import com.guoer.privilege.entity.Role;
import com.guoer.privilege.interfaces.assembler.RoleDTOAssembler;
import com.guoer.privilege.rpc.RoleServiceRpc;
import com.guoer.privilege.service.RoleService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.annotation.Resource;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:31
 * @description：
 * @version: 1.0.0
 */
//使用@DubboService暴露服务
@DubboService(version = "1.0.0",
        methods = {@Method(name = "create", timeout = 3000, retries = 0)}//单独为某个方法设置相关参数，这里的retries = 0表示该方法为非幂等，不能够重试，以防脏数据
)
public class RoleServiceProvider implements RoleServiceRpc {

    private static Logger logger = LogManager.getLogger(RoleServiceProvider.class);

    @Resource
    private RoleService roleService;

    private RoleDTOAssembler roleDTOAssembler = Mappers.getMapper(RoleDTOAssembler.class);

    @Override
    public R create(RoleDTO dto) {
        logger.info("创建角色：" + dto.toString());
        Role role = roleDTOAssembler.toRoleEntity(dto);
        boolean r = roleService.create(role);
        if (r) {
            //return R.ok(r);
            return R.ok();
        }
        logger.error("创建角色失败：" + dto.toString());
        return R.fail();
    }
}
