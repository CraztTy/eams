package com.xinke.eamscore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableCaching
@MapperScan("com.xinke.eamscore.system.mapper")
public class EamsCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EamsCoreApplication.class, args);


    }
}
