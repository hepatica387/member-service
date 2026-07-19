package com.memberService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.memberService")
@EntityScan("com.memberService.domain")
@EnableJpaRepositories("com.memberService.repository")
public class MemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

}
