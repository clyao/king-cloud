package com.clyao.securityjwt.utils;

import com.clyao.securityjwt.pojo.Result;

/**
 * 公共返回对象工具类
 */
public class ResultUtil {

    /**
     * 成功返回结果
     * @return
     */
    public static Result success(String msg){
        return new Result(200, msg, null);
    }

    /**
     * 成功返回带数据结果
     * @param msg
     * @param o
     * @return
     */
    public static Result success(String msg, Object o){
        return new Result(200, msg, o);
    }

    /**
     * 失败返回结果
     * @return
     */
    public static Result error(String msg){
        return new Result(500, msg, null);
    }

    /**
     * 失败返回带数据结果
     * @return
     */
    public static Result error(String msg, Object o){
        return new Result(500, msg, o);
    }

}
