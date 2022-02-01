package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.model.PrimaryCompositeKey;
import io.daobab.model.CompositeColumns;
import io.daobab.demo.dao.column.ActorId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.model.Table;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class FilmActor extends Table implements 
	FilmActorKey<FilmActor>,
	ActorId<FilmActor>,
	FilmId<FilmActor>,
	LastUpdate<FilmActor>,

	PrimaryCompositeKey<FilmActor,FilmActorKey<FilmActor>>
	{

	@Override
	public String getEntityName() {
		return "FILM_ACTOR";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
			new TableColumn(colActorId()).primaryKey().size(5),
			new TableColumn(colFilmId()).primaryKey().size(5),
			new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public FilmActor clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public CompositeColumns<FilmActorKey<FilmActor>> keyColumns() {
		return  compositeFilmActorKey();
		}


}
