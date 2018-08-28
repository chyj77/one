package com.lcw.one.sys;

import com.lcw.one.util.persistence.BaseRepositoryImpl;
import com.lcw.one.util.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAsync(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.lcw.one", repositoryBaseClass = BaseRepositoryImpl.class)
@EntityScan("com.lcw.one")
@ComponentScan("com.lcw.one")
@EnableSwagger2
@SpringBootApplication
public class OneSysApplication {

    private static final Logger logger = LoggerFactory.getLogger(OneSysApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(OneSysApplication.class, args);
        SpringContextHolder.setApplicationContext(applicationContext);
        logger.info("Registry ApplicationContext");
    }

}
