package com.clyao.mybatisplustest.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author clyao
 * @since 2022-03-08
 */
@Data
public class StudentDTO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createTime;
    private List<User> userList;
}
