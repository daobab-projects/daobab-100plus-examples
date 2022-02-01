package io.daobab.demo.dao;

import io.daobab.model.ResponseWrapper;
import io.daobab.target.database.remote.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/export")
public class SakilaEndpoint {

    @Autowired
    private SakilaDataBase db;

    @PostMapping("/db")
    public ResponseWrapper callDb(@RequestBody Map<String, Object> query) {
        return Endpoint.invoke(db, query);
    }


}
