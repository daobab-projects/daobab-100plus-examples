package io.daobab.demo.base;

import io.daobab.converter.JsonProvider;
import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaRemote;
import io.daobab.demo.dao.SakilaTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

public abstract class ServiceBase<V> implements SakilaTables, ToTableConverter {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected SakilaDataBase db;

    @Autowired
    protected SakilaRemote remote;

    public V callService() {
        return call(this::call);
    }

    public abstract V call();

    public void beforeCall(){
    }

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

    public void afterCall(V data){
        if (data==null){
            return;
        }
        log.info("************************************ -= result =- ************************************");
        if (data instanceof JsonProvider){
            log.info(((JsonProvider)data).toJson());
        }else if (data instanceof Collection){
            ((Collection<?>) data).forEach(o->log.info(o.toString()));
        }else if (data instanceof Object[]){
            Arrays.stream(((Object[]) data)).forEach(o->log.info(o.toString()));
        }else{
            log.info(data.toString());
        }
    }

    protected String info() {
        return "";
    }

}
