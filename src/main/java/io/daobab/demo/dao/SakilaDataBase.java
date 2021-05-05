package io.daobab.demo.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.model.Entity;
import io.daobab.target.database.DataBaseTarget;
import io.daobab.target.database.SqlQueryResolver;
import io.daobab.target.protection.Access;
import org.h2.tools.RunScript;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

@Component
public class SakilaDataBase extends DataBaseTarget implements SakilaTables, SqlQueryResolver {

    boolean recreate_database_on_start = true;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pass;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Override
    protected DataSource initDataSource() {

        var config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(pass);
        config.setDriverClassName(driverClassName);
        config.setSchema("PUBLIC");
        var db = new HikariDataSource(config);

        if (recreate_database_on_start) {
            createDatabaseContent(db);
        }

        getAccessProtector().setColumnAccess(tabActor.colLastName(), Access.NO_INSERT, Access.NO_UPDATE);


        return db;
    }

    @Override
    public boolean isLogQueriesEnabled() {
        return true;
    }

    @Override
    public List<Entity> initTables() {
        return Arrays.asList(
                tabActor,
                tabAddress,
                tabCategory,
                tabCity,
                tabCountry,
                tabCustomer,
                tabFilm,
                tabFilmActor,
                tabFilmCategory,
                tabFilmText,
                tabInventory,
                tabLanguage,
                tabPayment,
                tabRental,
                tabStaff,
                tabStore

        );
    }


    private void createDatabaseContent(DataSource ds) {

        try {
            var con = ds.getConnection();
            var script = new File(SakilaDataBase.class.getResource("/schema.sql").getFile());
            RunScript.execute(con, new FileReader(script));
            var script2 = new File(SakilaDataBase.class.getResource("/data.sql").getFile());
            RunScript.execute(con, new FileReader(script2));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database initialize script error");
        }

    }


}