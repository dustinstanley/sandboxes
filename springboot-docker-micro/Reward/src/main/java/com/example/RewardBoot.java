package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RewardBoot {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(RewardBoot.class);
	}
}
