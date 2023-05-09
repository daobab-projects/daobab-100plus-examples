package io.daobab.demo.dao;

import io.daobab.model.Entity;
import io.daobab.model.ResponseWrapper;
import io.daobab.query.base.Query;
import io.daobab.target.buffer.remote.RemoteClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SakilaRemote extends RemoteClient {

    @Value("${server.port}")
    private String port;

    @Override
    protected ResponseWrapper callEndpoint(Query<? extends Entity,?, ?> query, boolean singleResult) {

        final String url = "http://www.daobab.io/remote/export/db";

        //you may use the local url, but your application must be working
//        final String url = "http://localhost:" + port + "/export/db";


        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url,
                query.toRemote(singleResult),
                ResponseWrapper.class);
    }

}
