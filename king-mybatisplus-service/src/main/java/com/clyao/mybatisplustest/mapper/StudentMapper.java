package com.clyao.mybatisplustest.mapper;

import com.clyao.mybatisplustest.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clyao
 * @since 2022-03-08
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
