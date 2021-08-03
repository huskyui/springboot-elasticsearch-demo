package com.demo.elk.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 王鹏
 */
@Document(indexName = "books")
public class Book {
}
