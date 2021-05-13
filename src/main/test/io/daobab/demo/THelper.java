package io.daobab.demo;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.base.TestHelper;
import org.junit.Assert;

import java.util.List;
import java.util.function.Function;

public interface THelper extends TestHelper {


    List<ServiceBase> getExamples();

    default <V> V callExample(Class<? extends ServiceBase<V>> clazz){
        return (V)getExamples().stream().filter(s->s.getClass().getName().equals(clazz.getName())).findAny().get().call();
    }

    default <S extends ServiceBase<V>,V> V callExample(Class<S> clazz, Function<S,V> function){
        S service=(S)getExamples().stream().filter(s->s.getClass().getName().equals(clazz.getName())).findAny().get();
        return function.apply(service);
    }
    @Override
    default void check(Object obj) {
        Assert.assertNotNull(obj);
    }
}
