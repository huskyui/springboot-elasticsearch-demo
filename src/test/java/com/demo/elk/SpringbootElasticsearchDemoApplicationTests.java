package com.demo.elk;

import com.demo.elk.dao.EmployeeEsDao;
import com.demo.elk.entity.Employee;
import com.demo.elk.entity.EmployeeEs;
import com.demo.elk.mapper.EmployeeMapper;
import com.demo.elk.mapper.TestMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.*;

@SpringBootTest
class SpringbootElasticsearchDemoApplicationTests {

    @Autowired
    private RestHighLevelClient elasticsearchClient;

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private EmployeeEsDao employeeEsDao;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        List<Employee> employees = employeeMapper.selectList(10001 + 290024, 299924);
        List<EmployeeEs> employeeEsList = new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            EmployeeEs employeeEs = new EmployeeEs();
            BeanUtils.copyProperties(employee, employeeEs);
            employeeEsList.add(employeeEs);
        }
        employeeEsDao.saveAll(employeeEsList);
    }

    public static void main(String[] args) {
        int start = 100;
        int offset = 299924;

    }

    @Test
    public void testGetAll() {

        Pageable pageable = PageRequest.of(1,1000);
        Iterable<EmployeeEs> all = employeeEsDao.findAll(pageable);
        Iterator<EmployeeEs> iterator = all.iterator();
        while (iterator.hasNext()){
            EmployeeEs next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void createIndex() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("eventId", "eventId");


        IndexRequest indexRequest = new IndexRequest("event", "event", "123")
                .source(map);
        IndexResponse indexResponse = elasticsearchClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getResult());
    }

}
