package com.test.UserManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.test.UserManage.dao")
public class UserManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManageApplication.class, args);
	}
}
