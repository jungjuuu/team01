package com.cream.team01.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.edu.myboot.dao") // DAO 패키지 경로
public class accountlogingConfig {
    // DataSource 및 SqlSessionTemplate 설정
}