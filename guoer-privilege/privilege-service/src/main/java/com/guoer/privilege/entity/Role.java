package com.guoer.privilege.entity;

import com.guoer.common.dp.SimpleStatus;
import lombok.Data;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:19
 * @description：角色实体
 * @modified By：
 * @version: 1.0.0
 */
@Data  //TODO 为了支持对象自动映射，不得不暴露所有getter、setter方法
public class Role {

    private Integer roleId;

    private String roleName;

    private String description;

    private SimpleStatus status;

}
