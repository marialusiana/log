package com.example.blog.log.configuration.rpc;


import javax.annotation.PostConstruct;

import com.example.blog.log.service.SlmService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonRegisterServiceConfig {
    
    /**
     * Spring boot sudah melakukan auto config terhadap connection redis
     */
    @Autowired
    private RedissonClient redisson;

    /**
     * LicenseService di inject ke configuration agar implementation dari SlmService
     * dapat digunakan untuk register service
     */
    @Autowired
    private SlmService slmService;

    @PostConstruct
    public void register() {
        // mendaftarkan license service agar bisa diakses oleh module lain
        // by default redisson hanya set 1 invocation setiap connection, kita bisa set 
        // invocation dengan menambahkan parameter angka di akhir register
        // redisson hanya mendukung sampai 12 invocation

        // redisson.getRemoteService().register(LicenseService.class, licenseService, 12);
        redisson.getRemoteService().register(SlmService.class, slmService);
    }   

}