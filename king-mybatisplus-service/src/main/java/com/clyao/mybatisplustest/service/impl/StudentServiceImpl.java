package com.clyao.mybatisplustest.service.impl;

import com.clyao.mybatisplustest.entity.Student;
import com.clyao.mybatisplustest.mapper.StudentMapper;
import com.clyao.mybatisplustest.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clyao
 * @since 2022-03-08
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
