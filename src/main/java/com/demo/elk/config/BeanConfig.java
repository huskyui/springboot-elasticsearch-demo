package com.demo.elk.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author 王鹏
 */
@Configuration
public class BeanConfig {
    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;

    @Bean
    public RestHighLevelClient elasticsearchClient(){
        ClientConfiguration config = ClientConfiguration.builder()
                .connectedTo(elasticsearchUrl)
                .build();
        return RestClients.create(config).rest();
    }
}
