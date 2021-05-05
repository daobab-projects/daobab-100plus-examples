import org.junit.jupiter.api.Test;
//import table.ActivemqAcks;

import java.util.List;

import static io.daobab.statement.condition.Operator.NOT_NULL;

/**
 * @author Klaudiusz Wojtkowiak, (C) Elephant Software 2018-2021
 */
public class MyTest01 {//implements MyTables{

    TestDB db=new TestDB();

    @Test
    public void test(){
//        List<ActivemqAcks> aa=Select.from(db,tabActivemqAcks).where(tabActivemqAcks.colID(), NOT_NULL).result();
//
//        aa.forEach(a-> System.out.println(a));
    }
}
