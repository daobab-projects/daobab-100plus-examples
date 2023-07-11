package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.*;
import io.daobab.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuppressWarnings("rawtypes")
@TableInformation(name = "FILM")
public class Film extends Table<Film> implements
        FilmId<Film, Integer>,
        Title<Film, String>,
        Description<Film, String>,
        ReleaseYear<Film, LocalDateTime>,
        LanguageId<Film, Integer>,
        OriginalLanguageId<Film, Integer>,
        RentalDuration<Film, Integer>,
        RentalRate<Film, BigDecimal>,
        Length<Film, Integer>,
        ReplacementCost<Film, BigDecimal>,
        Rating<Film, String>,
        SpecialFeatures<Film, String>,
        LastUpdate<Film, LocalDateTime>,

        PrimaryKey<Film, Integer, FilmId> {


    public Film() {
        super();
    }

    public Film(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colFilmId()).primaryKey().size(16),
                new TableColumn(colTitle()).size(255),
                new TableColumn(colDescription()).size(1000),
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
    public Column<Film, Integer, FilmId> colID() {
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
