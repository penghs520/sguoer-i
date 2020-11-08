package com.guoer.admin.exception;

import com.guoer.common.response.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @ClassName GlobalExceptionHandler
 * @Deacription TODO
 * @Author penghs
 * @Date 2020/9/25 0025 13:51
 * @Version 1.0
 **/
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handle(Exception e){
        e.printStackTrace();
        return R.fail("服务异常");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public R handleIllegalArgumentException(IllegalArgumentException e){
        System.out.println("捕获到业务异常");
        if(e.getMessage().contains("登录超时")){//TODO 待优化
            return R.fail(10101,e.getMessage());
        }else if(e.getMessage().contains("机构下存在岗位，是否继续删除")){
            return R.fail(10328,e.getMessage());
        }
        return R.fail(e.getMessage());
    }

}
