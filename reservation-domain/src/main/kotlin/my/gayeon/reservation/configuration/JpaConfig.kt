package my.gayeon.reservation.configuration

import com.zaxxer.hikari.HikariDataSource
import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = [])
@EnableTransactionManagement
@EnableJpaAuditing
class JpaConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    fun hikariDataSource(): HikariDataSource{
        return dataSourceProperties()
            .initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

//    @Bean
    fun dataSource(): DataSource {
        return LazyConnectionDataSourceProxy(hikariDataSource())
    }

    @Bean
    fun entityManagerFactory(): EntityManagerFactory {
        val vendorAdapter = HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(true)

        val entityManagerFactory = LocalContainerEntityManagerFactoryBean()
        entityManagerFactory.jpaVendorAdapter = vendorAdapter
        entityManagerFactory.dataSource = dataSource()
        entityManagerFactory.setPackagesToScan("my.gayeon.reservation.domain.entity")
        entityManagerFactory.afterPropertiesSet()

        return entityManagerFactory.`object`!!
    }

    @Bean
    fun transactionManager(entityManagerFactory: EntityManagerFactory): JpaTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}