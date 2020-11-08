package com.guoer.privilege.rpc;

import com.guoer.common.response.R;
import com.guoer.privilege.dto.RoleDTO;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:27
 * @description：
 * @version: 1.0.0
 */
public interface RoleServiceRpc {

    R create(RoleDTO dto);

}
