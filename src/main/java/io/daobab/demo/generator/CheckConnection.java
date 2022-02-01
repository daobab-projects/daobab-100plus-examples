package io.daobab.demo.generator;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.generator.base.MySqlDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

@Component
public class CheckConnection extends MySqlDatabase {

    protected static String url="jdbc:mysql://127.0.0.1:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    protected static String user="root";
    protected static String pass="admin";


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, CheckConnection.class.getName());
    }

    public Void call() {
        //STEP 1: check the database connection
        generator.checkConnection(url,user,pass,com.mysql.cj.jdbc.Driver.class);
        return null;
    }


}
