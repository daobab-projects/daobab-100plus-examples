package io.daobab.demo.example.base;

import io.daobab.demo.dao.SakilaDataBase;
import io.daobab.demo.dao.SakilaTables;
import io.daobab.model.Entity;
import io.daobab.target.QueryTarget;
import io.daobab.target.multi.AboveMultiEntityTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InMemoryFilm extends AboveMultiEntityTarget implements SakilaTables {

    @Autowired
    private SakilaDataBase sakilaDataBase;

    @PostConstruct
    public void init() {
        register(tabFilm.getClass());//, Select.many(getSourceTarget(),tabFilm).where(tabFilm.colID(), LT,20));
        register(tabActor.getClass());
        register(tabFilmActor.getClass());
    }

    @Override
    protected QueryTarget getSourceTarget() {
        return sakilaDataBase;
    }

    @Override
    public List<Entity> getTables() {
        return List.of(
                tabFilm, tabActor, tabFilmActor);
    }
}
