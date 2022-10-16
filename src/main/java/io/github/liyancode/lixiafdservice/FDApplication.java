package io.github.liyancode.lixiafdservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyancode
 * @date 2022/10/16
 * @description
 */
@SpringBootApplication
@MapperScan({"io.github.liyancode.lixiafdservice.infra.persistant.mapper"})
public class FDApplication {
    public static void main(String[] args) {
        SpringApplication.run(FDApplication.class, args);
    }
}
