package io.daobab.demo.dao.procedure;

import io.daobab.model.ProcedureParameters;

import java.math.BigDecimal;

public class SomeOut extends ProcedureParameters {


    public SomeOut() {
        super(1);
        specifyValue(1, "test", BigDecimal.class);
    }

    public BigDecimal getResult() {
        return getValue("test");
    }

}
