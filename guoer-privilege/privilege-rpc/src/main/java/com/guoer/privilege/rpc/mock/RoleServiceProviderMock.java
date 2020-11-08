package com.guoer.privilege.rpc.mock;

import com.guoer.common.response.R;
import com.guoer.privilege.dto.RoleDTO;
import com.guoer.privilege.rpc.RoleServiceRpc;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:32
 * @description：
 * @version: 1.0.0
 */
public class RoleServiceProviderMock implements RoleServiceRpc {

    @Override
    public R create(RoleDTO dto) {
        return R.fail();
    }
}
