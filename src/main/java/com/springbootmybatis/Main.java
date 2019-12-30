package com.springbootmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @author beike
 * @date 2017/3/7
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class })
public class Main extends WebMvcConfigurationSupport {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Main.class, "classpath*:/spring/*.xml");
        app.run(args);
    }
}
