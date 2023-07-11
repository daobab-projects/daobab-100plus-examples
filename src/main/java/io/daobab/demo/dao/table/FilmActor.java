package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.ActorId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.model.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@TableInformation(name = "FILM_ACTOR")
public class FilmActor extends Table<FilmActor> implements
        FilmActorKey<FilmActor>,
        ActorId<FilmActor, Integer>,
        FilmId<FilmActor, Integer>,
        LastUpdate<FilmActor, LocalDateTime>,

        PrimaryCompositeKey<FilmActor, FilmActorKey<FilmActor>> {


    public FilmActor() {
        super();
    }

    public FilmActor(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colActorId()).primaryKey().size(16),
                new TableColumn(colFilmId()).primaryKey().size(16),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public CompositeColumns<FilmActorKey<FilmActor>> colCompositeId() {
        return compositeFilmActorKey();
    }


}
