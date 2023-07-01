package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.ActorId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.model.*;

public interface FilmActorKey<E extends Entity & ActorId<E, Integer> & FilmId<E, Integer>>
        extends ActorId<E, Integer>, FilmId<E, Integer>, Composite<E> {

    default CompositeColumns<FilmActorKey<E>> compositeFilmActorKey() {
        return new CompositeColumns<>(
                new TableColumn(colActorId()).primaryKey().size(16),
                new TableColumn(colFilmId()).primaryKey().size(16));
    }


}
