package com.teste.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.teste.api.services.DBService;

/**
 * @author Kalleo
 *
 */

@Configuration
@Profile("dev")
public class DevConfig
{
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados()
	{
		if(strategy.equals("create"))
		{
			this.dbService.instaciaDB();
		}
		return false;
	}
}
