package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.model.PrimaryKey;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.Title;
import io.daobab.demo.dao.column.Description;
import io.daobab.demo.dao.column.ReleaseYear;
import io.daobab.demo.dao.column.LanguageId;
import io.daobab.demo.dao.column.OriginalLanguageId;
import io.daobab.demo.dao.column.RentalDuration;
import io.daobab.demo.dao.column.RentalRate;
import io.daobab.demo.dao.column.Length;
import io.daobab.demo.dao.column.ReplacementCost;
import io.daobab.demo.dao.column.Rating;
import io.daobab.demo.dao.column.SpecialFeatures;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.model.Table;

import java.lang.Integer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Film extends Table implements 
	FilmId<Film>,
	Title<Film>,
	Description<Film>,
	ReleaseYear<Film>,
	LanguageId<Film>,
	OriginalLanguageId<Film>,
	RentalDuration<Film>,
	RentalRate<Film>,
	Length<Film>,
	ReplacementCost<Film>,
	Rating<Film>,
	SpecialFeatures<Film>,
	LastUpdate<Film>,

	PrimaryKey<Film,Integer,FilmId>
	{

	@Override
	public String getEntityName() {
		return "FILM";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
			new TableColumn(colFilmId()).unique().size(5),
			new TableColumn(colTitle()).size(255),
			new TableColumn(colDescription()).size(255),
			new TableColumn(colReleaseYear()).size(10),
			new TableColumn(colLanguageId()).size(3),
			new TableColumn(colOriginalLanguageId()).size(3),
			new TableColumn(colRentalDuration()).size(3),
			new TableColumn(colRentalRate()).size(4).scale(2),
			new TableColumn(colLength()).size(5),
			new TableColumn(colReplacementCost()).size(5).scale(2),
			new TableColumn(colRating()).size(5),
			new TableColumn(colSpecialFeatures()).size(54),
			new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public Film clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Film,Integer,FilmId> colID() {
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
