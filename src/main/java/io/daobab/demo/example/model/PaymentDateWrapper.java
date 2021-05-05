package io.daobab.demo.example.model;

import io.daobab.parser.ParserGeneral;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PaymentDateWrapper implements ParserGeneral {

    private Double money;
    private Date date;

    public PaymentDateWrapper(BigDecimal amount, Timestamp paymentDate) {
        setMoney(toDouble(amount));
        setDate(paymentDate);
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}