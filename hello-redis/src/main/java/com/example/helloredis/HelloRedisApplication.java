package com.example.helloredis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class HelloRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloRedisApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RedisTemplate<Object, Object> redisTemplate){
		return args -> {
			// Set giá trị của key "likelion" là "hello redis"
			redisTemplate.opsForValue().set("likelion", "hello redis");
			// In ra màn hình Giá trị của key "likelion" trong Redis
			System.out.println("Value of key likelion: " + redisTemplate.opsForValue().get("likelion"));
 		};
	}

}
