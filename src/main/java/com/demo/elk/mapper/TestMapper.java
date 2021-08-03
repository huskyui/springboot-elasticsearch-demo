package com.demo.elk.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 王鹏
 */
@Repository
public interface TestMapper {

    @Select("select 1")
    int test();



}
