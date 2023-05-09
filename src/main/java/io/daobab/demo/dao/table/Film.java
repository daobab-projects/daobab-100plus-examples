package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.demo.dao.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;
import io.daobab.model.TableColumn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Film extends Table implements
        FilmId<Film, Integer>,
        Title<Film, String>,
        Description<Film, String>,
        ReleaseYear<Film, LocalDate>,
        LanguageId<Film, Integer>,
        OriginalLanguageId<Film, Integer>,
        RentalDuration<Film, Integer>,
        RentalRate<Film, BigDecimal>,
        Length<Film, Integer>,
        ReplacementCost<Film, BigDecimal>,
        Rating<Film, String>,
        SpecialFeatures<Film, String>,
        LastUpdate<Film, LocalDateTime>,

        PrimaryKey<Film, Integer, FilmId>
	{

	@Override
	public String getEntityName() {
		return "FILM";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
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
