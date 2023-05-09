package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.demo.dao.column.CategoryId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.demo.dao.column.Name;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;
import io.daobab.model.TableColumn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@SuppressWarnings("rawtypes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Category extends Table implements
        CategoryId<Category, Integer>,
        Name<Category, String>,
        LastUpdate<Category, LocalDateTime>,

        PrimaryKey<Category, Integer, CategoryId>
	{

	@Override
	public String getEntityName() {
		return "CATEGORY";
	}

	@Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colCategoryId()).primaryKey().size(8),
                new TableColumn(colName()).size(25),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
	}

	@Override
	public Category clone() {
		return EntityDuplicator.cloneEntity(this);
	}

	@Override
	public Column<Category,Integer,CategoryId> colID() {
		return colCategoryId();
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
