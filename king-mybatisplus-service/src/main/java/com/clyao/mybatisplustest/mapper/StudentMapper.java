package com.clyao.mybatisplustest.mapper;

import com.clyao.mybatisplustest.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clyao.mybatisplustest.entity.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Select("select * from student s join user u on s.id = u.student_id where s.id=1")
    List<StudentDTO> getStudent();

    List<Student> getByAll(@Param("age") Integer age);
}
