package com.guoer.privilege.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:28
 * @description：
 * @version: 1.0.0
 */

@Data
public class RoleDTO implements Serializable {//TODO 需要网络传输，因此需要序列化

    private Integer id;

    private String roleName;

    private String description;

    private String status;

}
