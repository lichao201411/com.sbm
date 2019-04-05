package com.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class MybatisSpringConfig {
		/*@Primary
		@Bean(name = "masterDataSource")
		@ConfigurationProperties(prefix = "datasource.master")
		public DataSource dataSource() {
		return DataSourceBuilder.create().build();
		}
		@Primary

		@Bean(name = "masterTransactionManager")
		public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}
		
		@Bean(name = "slaveDataSource")
		@ConfigurationProperties(prefix = "datasource.slave")
		public DataSource dataSource2() {
			return DataSourceBuilder.create().build();
		}
		
		@Bean(name = "slaveTransactionManager")
		public DataSourceTransactionManager transactionManager1(@Qualifier("slaveDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);

		}*/
}
