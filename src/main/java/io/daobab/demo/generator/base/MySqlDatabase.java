package io.daobab.demo.generator.base;

import io.daobab.demo.base.ServiceBase;
import io.daobab.generator.DaobabGenerator;

public abstract class MySqlDatabase extends ServiceBase<Void> {

    protected static String url="jdbc:mysql://127.0.0.1:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    protected static String user="root";
    protected static String pass="admin";
    protected static Class driverClassName=com.mysql.cj.jdbc.Driver.class;

    protected static DaobabGenerator generator = new DaobabGenerator();

    protected Class getDriverClass(){
        return driverClassName;
    }

}
