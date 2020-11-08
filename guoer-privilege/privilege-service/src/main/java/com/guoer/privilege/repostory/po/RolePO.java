package com.guoer.privilege.repostory.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:41
 * @description：
 * @version: 1.0.0
 */
@Data
@TableName("t_sys_role")
public class RolePO {

    @TableId(value = "id", type = IdType.AUTO)//默认递增
    private Integer id;

    private String roleName;

    private String description;

    private String status;

    private Integer sortId;

}
