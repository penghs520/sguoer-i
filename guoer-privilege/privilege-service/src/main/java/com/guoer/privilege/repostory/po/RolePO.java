package com.guoer.privilege.repostory.po;

import lombok.Data;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:41
 * @description：
 * @version: 1.0.0
 */
@Data
public class RolePO {

    private Integer id;

    private String roleName;

    private String description;

    private String status;

    private Integer sortId;

}
