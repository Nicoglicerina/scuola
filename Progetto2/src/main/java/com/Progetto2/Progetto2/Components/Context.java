package com.Progetto2.Progetto2.Components;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class Context
{
    @Bean
     DataSource database()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://127.0.0.1:3306/scuola?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }
}
