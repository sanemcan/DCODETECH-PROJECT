package com.dcodetech.ATMMACHINE;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AtmSpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmSpringServerApplication.class, args);
	}

	@Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }

}
