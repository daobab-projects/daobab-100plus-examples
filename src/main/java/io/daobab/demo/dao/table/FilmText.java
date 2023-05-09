package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.demo.dao.column.Description;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.Title;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;
import io.daobab.model.TableColumn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class FilmText extends Table implements
        FilmId<FilmText, Integer>,
        Title<FilmText, String>,
        Description<FilmText, String>,

        PrimaryKey<FilmText, Integer, FilmId>
	{

	@Override
	public String getEntityName() {
		return "FILM_TEXT";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colFilmId()).primaryKey().size(16),
                new TableColumn(colTitle()).size(255),
                new TableColumn(colDescription()).size(1000000000)
        );
	}

	@Override
	public FilmText clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<FilmText,Integer,FilmId> colID() {
		return colFilmId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		PrimaryKey<?,?,?> other = (PrimaryKey<?,?,?>) obj;
		return Objects.equals(getId(), other.getId());
	}




}
