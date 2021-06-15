package io.daobab.demo.dao.procedure;

import io.daobab.model.ProcedureParameters;

public class SomeIn extends ProcedureParameters {


    public SomeIn(String test, Integer age) {
        super(2);
        specifyValue(1,"test",String.class);
        specifyValue(2,"age",Integer.class);
        setTest(test);
        setAge(age);

    }

    public String getTest(){
        return getValue("test");
    }

    public void setTest(String test){
        setValue(1,test);
    }

    public String getAge(){
        return getValue("age");
    }


    public void setAge(Integer age){
        setValue(2,age);
    }
}
