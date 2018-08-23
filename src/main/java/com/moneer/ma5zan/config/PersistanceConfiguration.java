package com.moneer.ma5zan.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfiguration {
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  @Primary
  public DataSource springDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource flywayDatasource(DataSourceProperties properties) {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }
}
