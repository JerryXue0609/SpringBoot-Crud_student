package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.StuException;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jerry on 2017/8/15 0015.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof StuException){
            StuException stuException = (StuException) e;
            return ResultUtil.error(stuException.getCode(),stuException.getMessage());
        }else {
            e.printStackTrace();
            return ResultUtil.error(-1,"未知错误");
        }
    }

}
