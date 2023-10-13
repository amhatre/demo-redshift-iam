package com.example.demo.cfg;

import com.example.demo.redshift.RedshiftConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Properties;

@Configuration
public class DemoAppConfig {

    @Value("${redshift.jdbc.url}")
    String jdbcUrl;

    @Value("${redshift.jdbc.username}")
    String dbUsername;

    @Value("${redshift.jdbc.password}")
    String dbPassword;

    public static final String START_BEAN = "startApplication";
    @Bean(START_BEAN)
    public void startApplication() throws Exception {

        RedshiftConnection redshiftConnection = new RedshiftConnection();

        Properties props = new Properties();
        if(!jdbcUrl.contains("iam")) {
            //Uncomment the following line if using a keystore.
            //props.setProperty("ssl", "true");
            props.setProperty("user", dbUsername);
            props.setProperty("password", dbPassword);
        }

        redshiftConnection.testConnection(jdbcUrl, props);
    }
}
