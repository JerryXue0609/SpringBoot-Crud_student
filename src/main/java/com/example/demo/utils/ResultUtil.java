package com.example.demo.utils;

import com.example.demo.domain.Result;

/**
 * Created by Jerry on 2017/8/15 0015.
 */
public class ResultUtil {
    public static Result success(Object o){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(o);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;

    }
}
