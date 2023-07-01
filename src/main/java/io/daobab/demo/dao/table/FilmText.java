package io.daobab.demo.dao.table;

import io.daobab.creation.DaobabCache;
import io.daobab.demo.dao.column.Description;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.Title;
import io.daobab.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "FILM_TEXT")
public class FilmText extends Table<FilmText> implements
	FilmId<FilmText>,
	Title<FilmText>,
	Description<FilmText>,

	PrimaryKey<FilmText,Integer,FilmId>
	{

	public FilmText() {
		super();
	}

		public FilmText(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colFilmId()).primaryKey().size(16),
			new TableColumn(colTitle()).size(255),
			new TableColumn(colDescription()).size(1000000000)

		));
	}

	
	@Override
	public Column< FilmText, Integer, FilmId> colID() {
		return colFilmId();
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
