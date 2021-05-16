package com.gestaofesta.gestaofesta.Banco;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//utilizando jpa/hibernate para conexão com a base de dados
@Configuration
public class ConfigurationData {

	@Bean

	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listaEvento");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;

	}
	
	@Bean

	public JpaVendorAdapter jpaVendorAdapter() {

	    final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.MYSQL);
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(true);
	    adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
	    //adapter.setPrepareConnection(true);
	    return adapter;

	}
}
