package national.library.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Configuration
@Component
public class DataSourceBean {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public static DataSource getDataSource() {
        return DataSourceBuilder
                .create().url("jdbc:postgresql://localhost/library").username("postgres").password("1618").driverClassName("org.postgresql.Driver")
                .build();
    }
}