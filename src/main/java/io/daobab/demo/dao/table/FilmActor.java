package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.ActorId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "FILM_ACTOR")
public class FilmActor extends Table<FilmActor> implements
	FilmActorKey<FilmActor>,
	ActorId<FilmActor>,
	FilmId<FilmActor>,
	LastUpdate<FilmActor>,

	PrimaryCompositeKey<FilmActor,FilmActorKey<FilmActor>>
	{

	public FilmActor() {
		super();
	}

	protected FilmActor(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colActorId()).primaryKey().size(16),
			new TableColumn(colFilmId()).primaryKey().size(16),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public CompositeColumns<FilmActorKey<FilmActor>> colCompositeId() {
		return  compositeFilmActorKey();
	}
}
