package com.infosharesystems.healthcare.telemed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.infosharesystems.healthcare.telemed.common.util.FeignClientErrorDecoder;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public FeignClientErrorDecoder feignClientErrorDecoder() {
	  return new FeignClientErrorDecoder();
	}
	
}
