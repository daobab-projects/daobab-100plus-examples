package io.daobab.demo;

import io.daobab.generator.DaobabGenerator;

public class ExampleGenerator {

    public static void main(String[] args) {
        DaobabGenerator generator = new DaobabGenerator();

        //STEP 1: check the database connection
        generator.checkConnection("jdbc:mysql://127.0.0.1:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "admin", com.mysql.cj.jdbc.Driver.class);

        //STEP 2: set variables
        generator.setPackage("io.daobab.demo.seconddao");
        //put the real path here:
        generator.setPath("E:\\IdeaProjects\\github\\daobab-100plus-examples_ok\\src\\main\\java\\io\\daobab\\demo\\seconddao");


        //STEP 3: execute reverse engineering
        generator.reverseEngineering("jdbc:h2:file:C:/temp/test", "sa", "", org.h2.Driver.class);


    }





}
