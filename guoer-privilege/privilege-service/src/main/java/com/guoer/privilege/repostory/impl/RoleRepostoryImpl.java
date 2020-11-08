package com.guoer.privilege.repostory.impl;

import com.guoer.privilege.repostory.RoleRepostory;
import com.guoer.privilege.repostory.mapper.RoleMapper;
import com.guoer.privilege.repostory.po.RolePO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:21
 * @description：角色Repostory实现
 * @version: 1.0.0
 */
@Repository
public class RoleRepostoryImpl implements RoleRepostory {

    private static Logger logger = LogManager.getLogger(RoleRepostoryImpl.class);

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Boolean save(RolePO po) {
        int r = 0;
        if (po.getId() == null || po.getId() == 0) {
            r = roleMapper.insert(po);
        } else {
            r = roleMapper.updateById(po);
        }
        if (r > 0) {
            logger.info("保存角色成功：" + po);
            return true;
        }
        logger.info("保存角色失败：" + po);
        return false;
    }
}
