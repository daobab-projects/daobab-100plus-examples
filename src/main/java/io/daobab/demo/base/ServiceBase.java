package io.daobab.demo.base;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaRemote;
import io.daobab.demo.dao.SakilaTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;

public abstract class ServiceBase<V> implements SakilaTables, ToTableConverter {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected SakilaDataBase db;

    @Autowired
    protected SakilaRemote remote;

    public V callService() {
        return call(() -> call());
    }

    public abstract V call();

    public V call(Supplier<V> scenario) {
        log.info("<hr>");
        log.info("Executing...." + this.getClass().getSimpleName());
        log.info("<div><br><i>" + info().replaceAll("\n", "<br>") + "</i><div>");
        V rv = null;
        try {
            rv = scenario.get();
            log.info("result:" + resultToTable(rv));
        } catch (Exception e) {
            log.info("error:", e);
        }
        return rv;
    }


    protected String info() {
        return "";
    }


}
