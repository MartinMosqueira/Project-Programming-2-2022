package app.project.FranchiseMicroservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "h2TransactionManager",
        basePackages = { "app.project.FranchiseMicroservice.repo.h2"})
public class H2Config {

    @Autowired
    private Environment env;

    @Bean(name = "h2DataSource")
    public DataSource h2Datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("h2.datasource.url"));
        dataSource.setUsername(env.getProperty("h2.datasource.username"));
        dataSource.setPassword(env.getProperty("h2.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("h2.datasource.driver-class-name"));

        return dataSource;
    }

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(h2Datasource());
        em.setPackagesToScan("app.project.FranchiseMicroservice.model.h2");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("h2.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("h2.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("h2.jpa.database-platform"));
        properties.put("hibernate.h2.console.enabled", env.getProperty("h2.h2.console.enabled"));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}
