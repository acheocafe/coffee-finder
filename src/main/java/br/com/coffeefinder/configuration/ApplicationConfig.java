package br.com.coffeefinder.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EntityScan(basePackages = "br.com.coffeefinder.entity")
@EnableJpaRepositories(basePackages = "br.com.coffeefinder.repository")
@PropertySource("classpath:application.properties")

class ApplicationConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.jpa.hibernate.dialect}")
    private String hibernateDialect;


    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName(driverClassName).url(jdbcUrl)
                .username(username).password(password).build();
    }
}
