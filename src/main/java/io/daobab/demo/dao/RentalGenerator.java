package io.daobab.demo.dao;

import io.daobab.statement.function.FunctionWhispererH2;
import io.daobab.target.database.DataBaseIdGeneratorSupplier;
import io.daobab.target.database.QueryTarget;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RentalGenerator implements DataBaseIdGeneratorSupplier<BigDecimal>, FunctionWhispererH2, SakilaTables {

    @Override
    public BigDecimal generateId(QueryTarget currentTarget) {
        return currentTarget.select(max(tabRental.colID())).findFirst().orElse(BigDecimal.ZERO).add(BigDecimal.ONE);
    }
}
