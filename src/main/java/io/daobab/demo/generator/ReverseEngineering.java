package io.daobab.demo.generator;

import io.daobab.demo.DemoApplication;
import io.daobab.demo.generator.base.H2Database;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.sql.Types;

@Component
public class ReverseEngineering extends H2Database {



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, ReverseEngineering.class.getName());
    }

    public Void call() {


        //STEP 2: set the package
        generator.setPackage("io.daobab.demo.dao");
        //put the real path here:
        generator.setPath("E:\\Daobabx\\");
//
//        generator.setGeneralConversionFor(Types.VARCHAR,StringBuilder.class);
//        generator.setEnforcedTypeFor("ADDRESS","ADDRESS",ReverseEngineering.class);

//        generator.generateOnlyForCatalogues("sakila");


        //STEP 3: execute reverse engineering
        generator.reverseEngineering(url,user,pass,getDriverClass());
        return null;

    }







}
