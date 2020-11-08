package com.guoer.admin.controller.role;

import com.guoer.common.response.R;
import com.guoer.privilege.dto.RoleDTO;
import com.guoer.privilege.rpc.RoleServiceRpc;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 21:07
 * @description：角色Controller
 * @version: 1.0.0
 */
@RequestMapping("/admin/role")
@RestController
@Api(tags = "【企业模块】企业|租户")
public class RoleController {

    @DubboReference(version = "1.0.0")
    private RoleServiceRpc roleServiceRpc;

    @GetMapping("/test")
    public R test() {
        RoleDTO dto = new RoleDTO();
        dto.setRoleName("管理员");
        R r = roleServiceRpc.create(dto);
        return r;
    }

}
