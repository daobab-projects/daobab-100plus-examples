package io.daobab.demo.dao;

import io.daobab.model.ResponseWrapper;
import io.daobab.target.database.remote.Endpoint;
import io.daobab.target.protection.Access;
import io.daobab.target.protection.AccessProtector;
import io.daobab.target.protection.BasicAccessProtector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
@RequestMapping("/export")
public class SakilaEndpoint implements SakilaTables{

    @Autowired
    private SakilaDataBase db;

    private AccessProtector protector;

    @PostConstruct
    public void init(){
        protector=new BasicAccessProtector(db);
        protector.setEntityAccess(tabPayment, Access.NO_READ);
    }

    @PostMapping("/db")
    public ResponseWrapper callDb(@RequestBody Map<String, Object> query) {
        System.out.println("CALLED");
        ResponseWrapper rv= Endpoint.invoke(db,protector, query);

        System.out.println(rv.getContent());

        return rv;
    }


}
