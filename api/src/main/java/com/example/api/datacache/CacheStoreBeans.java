package com.example.api.datacache;

import com.example.api.entities.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author - Anuradha Ranasinghe on 2021-07-07
 * @project - GuavaCache
 **/
@Configuration
public class CacheStoreBeans {

    @Bean
    public CacheStore<Student> employeeCache() {
        return new CacheStore<Student>(120, TimeUnit.SECONDS);
    }

    @Bean
    public CacheStore<String> productNameCache() {
        return new CacheStore<String>(1, TimeUnit.HOURS);
    }
}
