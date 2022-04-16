package com.clyao.securityjwt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -5906240125311919229L;

    private Integer code;

    private String msg;

    private Object object;

}
