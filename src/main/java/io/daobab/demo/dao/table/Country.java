package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;
import io.daobab.model.TableColumn;
import io.daobab.model.PrimaryKey;
import io.daobab.demo.dao.column.CountryId;
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
public class Country extends Table implements 
	CountryId<Country>,
	io.daobab.demo.dao.column.Country<Country>,
	LastUpdate<Country>,

	PrimaryKey<Country,Integer,CountryId>
	{

	@Override
	public String getEntityName() {
		return "COUNTRY";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
			new TableColumn(colCountryId()).primaryKey().size(5),
			new TableColumn(colCountry()).size(50),
			new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public Country clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Country,Integer,CountryId> colID() {
		return colCountryId();
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
