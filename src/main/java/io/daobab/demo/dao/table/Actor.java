package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.ActorId;
import io.daobab.demo.dao.column.FirstName;
import io.daobab.demo.dao.column.LastName;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "ACTOR")
public class Actor extends Table<Actor> implements
	ActorId<Actor>,
	FirstName<Actor>,
	LastName<Actor>,
	LastUpdate<Actor>,

	PrimaryKey<Actor,Integer,ActorId>
	{

	public Actor() {
		super();
	}

	Actor(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colActorId()).primaryKey().size(16),
			new TableColumn(colFirstName()).size(45),
			new TableColumn(colLastName()).size(45),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Actor, Integer, ActorId> colID() {
		return colActorId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		PrimaryKey<?, ?, ?> other = (PrimaryKey<?, ?, ?>) obj;
		return Objects.equals(getId(), other.getId());
	}


}
