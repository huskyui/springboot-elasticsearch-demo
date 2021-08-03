package com.demo.elk.mapper;

import com.demo.elk.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 王鹏
 */
@Repository
public interface EmployeeMapper {

    List<Employee> selectList(@Param("start")Integer start,@Param("offset")Integer offset);

}
