package io.daobab.demo.generator.base;

import io.daobab.demo.base.ServiceBase;
import io.daobab.generator.DaobabGenerator;
import org.springframework.beans.factory.annotation.Value;


public abstract class H2Database extends ServiceBase<Void> {

    @Value("${spring.datasource.url}")
    protected String url;
    @Value("${spring.datasource.username}")
    protected String user;
    @Value("${spring.datasource.password}")
    protected String pass;
    @Value("${spring.datasource.driverClassName}")
    protected String driverClassName;

    protected static DaobabGenerator generator = new DaobabGenerator();

    protected Class getDriverClass(){
        try {
            return Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
