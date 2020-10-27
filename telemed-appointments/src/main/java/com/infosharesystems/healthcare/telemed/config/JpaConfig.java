package com.infosharesystems.healthcare.telemed.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = {"com.infosharesystems.healthcare.telemed.model"})
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
		"com.infosharesystems.healthcare.telemed.repository" })
public class JpaConfig {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@Bean(name = "flyway")
	public Flyway getFlyway() {

		org.flywaydb.core.Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource);
		flyway.setBaselineOnMigrate(true);
		flyway.repair();
		flyway.migrate();
		return flyway;
	}	
}
