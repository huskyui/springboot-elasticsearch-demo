package com.demo.elk.dao;

import com.demo.elk.entity.EmployeeEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 王鹏
 */
@Repository
public interface EmployeeEsDao extends ElasticsearchRepository<EmployeeEs, Integer> {
}
