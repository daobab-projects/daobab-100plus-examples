package io.daobab.demo;

import io.daobab.generator.DaobabGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    //Rename this method to main and execute it if you want to generate reverse engineering classes
    //remember to put the correct FileDirectoryPath relevant to your file directory before the execution
//    public static void mainaa(String[] args) {
//
//        //initDataSource());
////        generator.checkConnection("jdbc:h2:file:C:/temp/test", "sa", "", org.h2.Driver.class);
////        jdbc:postgresql://host:port/database
//
////        DaobabGenerator generator = new DaobabGenerator();
////        generator.setPackage("io.daobab.demo.dao3");
////        generator.setPath("E:\\IdeaProjects\\github\\daobab-projects\\daobab-100plus-examples\\src\\main\\java\\io\\daobab\\demo\\dao3");
////        generator.reverseEngineering("jdbc:postgresql://localhost:5432/postgres",
////                "postgres",
////                "admin",
////                org.postgresql.Driver.class);
//
//
//
//        //        generator.allowOnlyCatalogues("l2","mdm");
//        generator.setPackage("io.daobab.demo.dao3");
//        generator.setOverride(true);
////        generator.allowOnlyTables("category");
////        generator.allowOnlyCatalogues("test");
//        generator.setPath("E:\\IdeaProjects\\github\\daobab-projects\\daobab-100plus-examples\\src\\main\\java\\io\\daobab\\demo\\dao3");
//    }





}
