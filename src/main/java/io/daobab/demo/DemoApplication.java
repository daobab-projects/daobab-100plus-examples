package io.daobab.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.generator.DaobabGenerator;
import io.daobab.generator.ImageExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoApplication {

    //	@Override
    static DataSource initDataSource() {
//		setEnabledLogQueries("true".equalsIgnoreCase(env.getProperty(config_prefix+"log")));


        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/l2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
        config.setUsername("root");
        config.setPassword("admin");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setSchema("l2");
        return new HikariDataSource(config);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    //Rename this method to main and execute it if you want to check the database connection
    public static void main3(String[] args) {

        DaobabGenerator generator = new DaobabGenerator();//initDataSource());
        generator.checkConnection("jdbc:h2:file:C:/temp/test", "sa", "", org.h2.Driver.class);
        generator.reverseEngineering(initDataSource());
    }

    //Rename this method to main and execute it if you want to generate reverse engineering classes
    //remember to put the correct FileDirectoryPath relevant to your file directory before the execution
    public static void mainaa(String[] args) {

        //initDataSource());
//        generator.checkConnection("jdbc:h2:file:C:/temp/test", "sa", "", org.h2.Driver.class);
//        jdbc:postgresql://host:port/database



        DaobabGenerator generator = new DaobabGenerator();
        generator.setPackage("io.daobab.demo.dao3");
        generator.setPath("E:\\IdeaProjects\\github\\daobab-projects\\daobab-100plus-examples\\src\\main\\java\\io\\daobab\\demo\\dao3");
        generator.reverseEngineering("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "admin",
                org.postgresql.Driver.class);



        //        generator.allowOnlyCatalogues("l2","mdm");
        generator.setPackage("io.daobab.demo.dao3");
        generator.setOverride(true);
//        generator.allowOnlyTables("category");
//        generator.allowOnlyCatalogues("test");
        generator.setPath("E:\\IdeaProjects\\github\\daobab-projects\\daobab-100plus-examples\\src\\main\\java\\io\\daobab\\demo\\dao3");

//        generator.generateColumn("test","TEST_ID", JdbcType.DECIMAL,String.class);
//                generator.generateClasses("jdbc:mysql://127.0.0.1:3306/mdm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "admin", com.mysql.cj.jdbc.Driver.class);

//        generator.generateAll(initDataSource());
//        generator.generateAll("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin", org.postgresql.Driver.class);
//        generator.generateAll("jdbc:mysql://127.0.0.1:3306/mdm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "admin", com.mysql.jdbc.Driver.class);
    }


    public static void mainC(String[] args) {

        ImageExporter generator = new ImageExporter(initDataSource());
//        generator.checkConnection("jdbc:h2:file:C:/temp/test", "sa", "", org.h2.Driver.class);
//        generator.checkConnection("jdbc:mysql://127.0.0.1:3306/mdm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "admin", Driver.class);

//		generator.setSchema("PUBLIC");
//        generator.setJavaPackage("io.daobab.demo.dao3");
//        generator.setFileDirectoryPath("E:\\IdeaProjects\\github\\daobab-projects\\daobab-100plus-examples\\src\\main\\java\\io\\daobab\\demo\\dao3");
//        generator.setOverride(true);
//        generator.setSchema("l2");
//        generator.createTables();

    }


}
