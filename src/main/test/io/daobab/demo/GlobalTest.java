package io.daobab.demo;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.example.a_novice.*;
import io.daobab.demo.example.b_beginner.*;
import io.daobab.demo.example.c_talented.*;
import io.daobab.demo.example.d_proficient.*;
import io.daobab.demo.example.e_expert.*;
import io.daobab.error.MandatoryWhere;
import io.daobab.error.SqlInjectionDetected;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalTest implements THelper {
    private Logger log = LoggerFactory.getLogger("Test");

    @Override
    public Logger getLog() {
        return log;
    }
    @Autowired
    private List<ServiceBase> examples;

    @Override
    public List<ServiceBase> getExamples() {
        return examples;
    }



    @Test
    public void testCount(){
        validation(callExample(Count.class));
    }

    @Test
    public void testDistinct(){
        validation(callExample(Distinct.class));
    }

    @Test
    public void testEnums(){
        validation(callExample(Enums.class));
    }

    @Test
    public void testLimit(){
        validation(callExample(Limit.class));
    }

    @Test
    public void testManyPlatesManyTables(){
        validation(callExample(ManyPlatesManyTables.class));
    }

    @Test
    public void testOnePlateManyTables(){
        validation(callExample(OnePlateManyTables.class));
    }

    @Test
    public void testOrder(){
        validation(callExample(Order.class));
    }

    @Test
    public void testSelectAll(){
        validation(callExample(SelectAll.class));
    }

    @Test
    public void testSelectBlob(){
        validation(callExample(SelectBlob.class));
    }

    @Test
    public void testSelectField(){
        validation(callExample(SelectField.class));
    }

    @Test
    public void testSelectFieldList(){
        validation(callExample(SelectFieldList.class));
    }

    @Test
    public void testSelectManyEntities(){
        validation(callExample(SelectManyEntities.class));
    }

    @Test
    public void testSelectOneEntity(){
        validation(callExample(SelectOnePrimaryKeyEntity.class));
    }

    @Test
    public void testSelectPlate(){
        validation(callExample(SelectPlate.class));
    }

    @Test
    public void testWhereAnd(){
        validation(callExample(WhereAnd.class));
    }

    @Test
    public void testWhereNot(){
        validation(callExample(WhereNot.class));
    }

    @Test
    public void testWhereOr(){
        validation(callExample(WhereOr.class));
    }

    @Test
    public void testWhereSingleCondition(){
        validation(callExample(WhereSingleCondition.class));
    }

    @Test
    public void testBuildInParsers(){
        validation(callExample(BuildInParsers.class));
    }

    @Test
    public void testChainedSettingAndInsert(){
        validation(callExample(ChainedSettingAndInsert.class));
    }

    @Test
    public void testDistinctCount(){
        validation(callExample(DistinctCount.class));
    }

    @Test
    public void testFunctionAvg(){
        validation(callExample(FunctionAvg.class));
    }

    @Test
    public void testFunctionLower(){
        validation(callExample(FunctionLower.class));
    }

    @Test
    public void testFunctionMax(){
        validation(callExample(FunctionMax.class));
    }

    @Test
    public void testFunctionMin(){
        validation(callExample(FunctionMin.class));
    }

    @Test
    public void testFunctionSum(){
        validation(callExample(FunctionSum.class));
    }

    @Test
    public void testPlateAsEntity(){
        validation(callExample(PlateAsEntity.class));
    }

    @Test
    public void testPrimaryKeyDelete(){
        validation(callExample(PrimaryKeyDelete.class));
    }

    @Test
    public void testPrimaryKeyInsert(){
        validation(callExample(PrimaryKeyInsert.class));
    }

    @Test
    public void testPrimaryKeyUpdate(){
        validation(callExample(PrimaryKeyUpdate.class));
    }

    @Test
    public void testResultConsumer(){
        validation(callExample(ResultConsumer.class));
    }

    @Test
    public void testResultMapper(){
        validation(callExample(ResultMapper.class));
    }

    @Test
    public void testToJsonEntities(){
        validation(callExample(ToJsonEntities.class));
    }

    @Test
    public void testToJsonEntity(){
        validation(callExample(ToJsonEntity.class));
    }

    @Test
    public void testToJsonPlate(){
        validation(callExample(ToJsonPlate.class));
    }

    @Test
    public void testWhereManyConditions(){
        validation(callExample(WhereManyConditions.class));
    }

    @Test
    public void testBigQuery(){
        validation(callExample(BigQuery.class));
    }

    @Test
    public void testByteBuffer(){
        validation(callExample(ByteBuffer.class));
    }

    @Test
    public void testCloningEntities(){
        validation(callExample(CloningEntities.class));
    }

    @Test
    public void testCombinedFunctions(){
        validation(callExample(CombinedFunctions.class));
    }

    @Test
    public void testConcurrencySafeDelete(){
        validation(callExample(ConcurrencySafeDelete.class));
    }

    @Test
    public void testConcurrencySafeUpdate(){
        validation(callExample(ConcurrencySafeUpdate.class));
    }

    @Test
    public void testCountDistinct(){
        validation(callExample(CountDistinct.class));
    }

    @Test
    public void testDateFunctions(){
        validation(callExample(DateFunctions.class));
    }

    @Test
    public void testFlatPlateExample(){
        validation(callExample(FlatPlateExample.class));
    }

    @Test
    public void testGroupBy(){
        validation(callExample(GroupBy.class));
    }

    @Test
    public void testHaving(){
        validation(callExample(Having.class));
    }

    @Test
    public void testAboveMultiEntity(){
        validation(callExample(AboveMultiEntity.class));
    }

    @Test
    public void testInMemoryCascadeSelects(){
        validation(callExample(InMemoryCascadeSelects.class));
    }

    @Test
    public void testInMemoryFilterAndMap(){
        validation(callExample(EntitiesStream.class));
    }

    @Test
    public void testInMemoryInnerSelect(){
        validation(callExample(InMemoryInnerSelect.class));
    }

    @Test
    public void testInMemorySelect(){
        validation(callExample(InMemorySelect.class));
    }

    @Test
    public void testInnerSelect(){
        validation(callExample(InnerSelect.class));
    }

    @Test
    public void testInsertSelect(){
        validation(callExample(InsertSelect.class));
    }

    @Test
    public void testJoinLeft(){
        validation(callExample(JoinLeft.class));
    }

    @Test
    public void testJoinManyTables(){
        validation(callExample(JoinManyTables.class));
    }

    @Test
    public void testJoinPrimaryKeyTable(){
        validation(callExample(JoinPrimaryKeyTable.class));
    }

    @Test
    public void testJoinTable(){
        validation(callExample(JoinTable.class));
    }

    @Test
    public void testJoinViaDifferentColumns(){
        validation(callExample(JoinViaDifferentColumns.class));
    }

    @Test
    public void testJoinWithJoinConditions(){
        validation(callExample(JoinWithJoinConditions.class));
    }

    @Test
    public void testLimitOffset(){
        validation(callExample(LimitOffset.class));
    }

    @Test
    public void testManyFunctions(){
        validation(callExample(ManyFunctions.class));
    }

    @Test
    public void testMinus(){
        validation(callExample(Minus.class));
    }

    @Test
    public void testOrderJoinManyTables(){
        validation(callExample(OrderJoinManyTables.class));
    }

    @Test
    public void testPagination(){
        validation(callExample(Pagination.class));
    }

    @Test
    public void testSelectFromDual(){
        validation(callExample(SelectFromDual.class));
    }

    @Test
    public void testSelectNativeManyCells(){
        validation(callExample(SelectNativeManyCells.class));
    }

    @Test
    public void testSelectNativeManyEntities(){
        validation(callExample(SelectNativeManyEntities.class));
    }

    @Test
    public void testSelectNativeOneEntity(){
        validation(callExample(SelectNativeOneEntity.class));
    }

    @Test
    public void testSelectNativePlate(){
        validation(callExample(SelectNativePlate.class));
    }

    @Test
    public void testStatistic(){
        Assert.assertNull(callExample(Statistic.class));
    }

    @Test
    public void testTransactionManual(){
        Assert.assertNull(callExample(TransactionManual.class));
    }

    @Test
    public void testTransactionWrapper(){
        validation(callExample(TransactionWrapper.class));
    }

    @Test
    public void testTransactionWrapperAsynchronous(){
        validation(callExample(TransactionWrapperAsynchronous.class));
    }

    @Test
    public void testE075(){
        validation(callExample(TransactionWrapperVoid.class));
    }

    @Test
    public void testUnionAll(){
        validation(callExample(UnionAll.class));
    }

    @Test
    public void testUpdateSelectedOnly(){
        validation(callExample(UpdateSelectedOnly.class));
    }

    @Test
    public void testWhereInAndArrays(){
        validation(callExample(WhereInAndArrays.class));
    }

    @Test
    public void testWhereManyCombined(){
        validation(callExample(WhereManyCombined.class));
    }

    @Test
    public void testE080(){
        validation(callExample(WhereNotNullIsNull.class));
    }

    @Test
    public void testE081(){
        validation(callExample(ConditionalWhere.class));
    }

    @Test
    public void testE082(){
        validation(callExample(ConditionIfNotNull.class));
    }

    @Test
    public void testE083(){
        validation(callExample(DateTimeConversions.class));
    }

    @Test
    public void testE084(){
        validation(callExample(MetaDataColumnDatatype.class));
    }

    @Test
    public void testE085(){
        validation(callExample(MetaDataAsQueryTarget.class));
    }

    @Test
    public void testE086(){
        validation(callExample(MultiEntity.class));
    }

    @Test
    public void testE087(){
        validation(callExample(PrimaryKeyFindManyToManyRelated.class));
    }

    @Test
    public void testE088(){
        validation(callExample(PrimaryKeyFindManyToManyRelatedColumns.class));
    }

    @Test
    public void testE089(){
        validation(callExample(PrimaryKeyFindOneToOneRelated.class));
    }

    @Test
    public void testE090(){
        validation(callExample(PrimaryKeyFindOneToOneRelatedColumns.class));
    }

    @Test
    public void testE091(){
        validation(callExample(QueryMultiEntity.class));
    }

    @Test
    public void testE092(){
        validation(callExample(RemotePlate.class));
    }

    @Test
    public void testE093(){
        callExample(RemoteSecurityForbiddenColumns.class);
    }

    @Test
    public void testE094(){
        validation(callExample(RemoteSecurityForbiddenEntities.class));
    }

    @Test
    public void testE095(){
        validation(callExample(RemoteSelectManyCells.class));
    }

    @Test
    public void testE096(){
        validation(callExample(RemoteSelectManyColumns.class));
    }

    @Test
    public void testE097(){
        validation(callExample(RemoteSelectManyEntities.class));
    }

    @Test
    public void testE098(){
        validation(callExample(RemoteSelectOneEntity.class));
    }

    @Test
    public void testE099(){
        validation(callExample(ResultPostProcessor.class));
    }

    @Test
    public void testE100() {
        validation(callExample(TransactionPropagation.class));
    }

    @Test
    public void testE101() {
        Assert.assertThrows(SqlInjectionDetected.class, () -> callExample(SqlInjectionProtection.class));
    }

    @Test
    public void testE102() {
        callExample(AbstractQueryAddressRelatedItems.class);
    }

    @Test
    public void testE103() {
        callExample(AbstractQueryLastRecord.class);
    }

    @Test
    public void testE104() {
        callExample(EagerLoading.class);
    }

    @Test
    public void testE106() {
        callExample(EmbeddedColumns.class);
    }

    @Test
    public void testE107() {
        Assert.assertThrows(MandatoryWhere.class, () -> callExample(AccidentalDeleteProtection.class));
    }

    @Test
    public void testE108() {
        callExample(EnhancedEntity.class);
    }

    @Test
    public void testE109() {
        callExample(LazyLoading.class);
    }

    @Test
    public void testE110() {
        callExample(LinkingEntitiesByWhere.class);
    }
    @Test
    public void testE111() {
        callExample(OptimisticConcurrencyControlForPrimaryKey.class);
    }
    public void testE112() {
        callExample(QueryOptimisation.class);
    }
    public void testE113() {
        callExample(ValidateSchemaCompliant.class);
    }


}
