package com.guoer.common.dp;

import java.util.Arrays;

/**
 * @author ：penghs
 * @date ：Created in 2020/11/8 20:40
 * @description：简单状态属性：on、off
 * @version: 1.0.0
 */
public class SimpleStatus {

    private String status = "on";

    private static final String[] statusArr = new String[]{"on", "off"};


    public SimpleStatus(String status) {
        verify(status);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        verify(status);
        this.status = status;
    }

    private void verify(String status) {
        if (status != null && !Arrays.asList(statusArr).contains(status)) {
            throw new IllegalArgumentException("不支持的状态：" + status);
        }
    }

}
