package com.example.demo.utils;

import org.springframework.core.env.Environment;

import java.util.Properties;

public class JpaUtils {

	private JpaUtils() {
	}

	public static Properties getJpaProperties(Environment env) {
		Properties jpaProperties = new Properties();

		// Configures the used database dialect. This allows Hibernate to create SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));

		// Specifies the action that is invoked to the database when the Hibernate
		// SessionFactory is created or closed.
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));

		// Configures the naming strategy that is used when Hibernate creates
		// new database objects and schema elements
		jpaProperties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));

		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics", "false"));

		// If the value of this property is true, Hibernate will format the SQL
		// that is written to the console.
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		// Tells Hypersistence which Object Mapper instance to use
		jpaProperties.put("hypersistence.utils.jackson.object.mapper",
				env.getProperty("hypersistence.utils.jackson.object.mapper",
						"com.triplelift.deals_api.config.jackson.HibernateObjectMapperSupplier"));
		return jpaProperties;
	}
}
