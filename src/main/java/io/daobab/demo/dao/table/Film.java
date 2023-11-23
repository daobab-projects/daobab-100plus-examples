package io.daobab.demo.dao.table;

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

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "FILM")
public class Film extends Table<Film> implements
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

	public Film() {
		super();
	}

	protected Film(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colFilmId()).primaryKey().size(16),
			new TableColumn(colTitle()).size(255),
			new TableColumn(colDescription()).size(1000000000),
			new TableColumn(colReleaseYear()).size(10),
			new TableColumn(colLanguageId()).size(8),
			new TableColumn(colOriginalLanguageId()).size(8),
			new TableColumn(colRentalDuration()).size(8),
			new TableColumn(colRentalRate()).size(4).scale(2),
			new TableColumn(colLength()).size(16),
			new TableColumn(colReplacementCost()).size(5).scale(2),
			new TableColumn(colRating()).size(5),
			new TableColumn(colSpecialFeatures()).size(54),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public Column< Film, Integer, FilmId> colID() {
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
