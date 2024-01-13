package com.tallstech.volunteer.config;

import static com.tallstech.volunteer.constant.JdbcConstants.JDBC_TEMPLATE;

import javax.sql.DataSource;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Getter
@Configuration
public class DataSourceConfig {

    /*
    * Datasource nedir?
    * @Bean nedir?
    * @ConfigurationProperties nedir?
    * JdbcTemplate sınıfının amacı nedir?
    * */

    @Bean(name = "DataSource")
    @ConfigurationProperties(prefix = "cvs.datasource")
    public DataSource createDocumentDataSource() {
        return  DataSourceBuilder.create()
                .build();
    }

    @Bean(name = JDBC_TEMPLATE)
    @Primary
    public JdbcTemplate createJdbcTemplate(@Qualifier("DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}