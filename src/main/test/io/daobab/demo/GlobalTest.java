package io.daobab.demo;

import io.daobab.demo.base.ServiceBase;
import io.daobab.demo.example.function.*;
import io.daobab.demo.example.part_a.*;
import io.daobab.demo.example.part_b.*;
import io.daobab.demo.example.part_c.*;
import io.daobab.demo.example.part_d.*;
import io.daobab.demo.example.part_e.*;
import io.daobab.error.DaobabSQLException;
import io.daobab.error.MandatoryWhere;
import io.daobab.error.SqlInjectionDetected;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("java:S2699")
@SpringBootTest
class GlobalTest implements THelper {
    private final Logger log = LoggerFactory.getLogger("Test");

    @Override
    public Logger getLog() {
        return log;
    }

    @SuppressWarnings("rawtypes")
    @Autowired
    private List<ServiceBase> examples;

    @SuppressWarnings("rawtypes")
    @Override
    public List<ServiceBase> getExamples() {
        return examples;
    }



    @Test
    void testCount(){
        callExample(Count.class);
    }

    @Test
    void testDistinct(){
        validation(callExample(Distinct.class));
    }

    @Test
    void testEnums(){
        validation(callExample(Enums.class));
    }

    @Test
    void testLimit(){
        validation(callExample(Limit.class));
    }

    @Test
    void testManyPlatesManyTables(){
        validation(callExample(ManyPlatesManyTables.class));
    }

    @Test
    void testOnePlateManyTables(){
        validation(callExample(OnePlateManyTables.class));
    }

    @Test
    void testOrder(){
        validation(callExample(Order.class));
    }

    @Test
    void testSelectAll(){
        validation(callExample(SelectAll.class));
    }

    @Test
    void testSelectBlob(){
        validation(callExample(SelectBlob.class));
    }

    @Test
    void testSelectField(){
        validation(callExample(SelectField.class));
    }

    @Test
    void testSelectFieldList(){
        validation(callExample(SelectFieldList.class));
    }

    @Test
    void testSelectManyEntities(){
        validation(callExample(SelectManyEntities.class));
    }

    @Test
    void testSelectOneEntity(){
        validation(callExample(SelectOnePrimaryKeyEntity.class));
    }

    @Test
    void testSelectPlate(){
        validation(callExample(SelectPlate.class));
    }

    @Test
    void testWhereAnd(){
        validation(callExample(WhereAnd.class));
    }

    @Test
    void testWhereNot(){
        validation(callExample(WhereNot.class));
    }

    @Test
    void testWhereOr(){
        validation(callExample(WhereOr.class));
    }

    @Test
    void testWhereSingleCondition(){
        validation(callExample(WhereSingleCondition.class));
    }

    @Test
    void testBuildInParsers(){
        validation(callExample(BuildInParsers.class));
    }

    @Test
    void testChainedSettingAndInsert(){
        validation(callExample(ChainedSettingAndInsert.class));
    }

    @Test
    void testDistinctCount(){
        validation(callExample(DistinctCount.class));
    }

    @Test
    void testFunctionAvg(){
        validation(callExample(FunctionAvg.class));
    }

    @Test
    void testFunctionSumRows(){
        validation(callExample(FunctionSumRows.class));
    }

    @Test
    void testFunctionLower(){
        validation(callExample(FunctionLower.class));
    }

    @Test
    void testFunctionMax(){
        validation(callExample(FunctionMax.class));
    }

    @Test
    void testFunctionMin(){
        validation(callExample(FunctionMin.class));
    }

    @Test
    void testFunctionSum(){
        validation(callExample(FunctionSum.class));
    }

    @Test
    void testPlateAsEntity(){
        validation(callExample(PlateAsEntity.class));
    }

    @Test
    void testPrimaryKeyDelete(){
        validation(callExample(PrimaryKeyDelete.class));
    }

    @Test
    void testPrimaryKeyInsert(){
        validation(callExample(PrimaryKeyInsert.class));
    }

    @Test
    void testPrimaryKeyUpdate(){
        validation(callExample(PrimaryKeyUpdate.class));
    }

    @Test
    void testResultConsumer(){
        validation(callExample(ResultConsumer.class));
    }

    @Test
    void testExists(){
        validation(callExample(Exists.class));
    }

    @Test
    void testToJsonEntities(){
        validation(callExample(ToJsonEntities.class));
    }

    @Test
    void testToJsonEntity(){
        validation(callExample(ToJsonEntity.class));
    }

    @Test
    void testToJsonPlate(){
        validation(callExample(ToJsonPlate.class));
    }

    @Test
    void testWhereManyConditions(){
        validation(callExample(WhereManyConditions.class));
    }

    @Test
    void testBigQuery(){
        validation(callExample(BigQuery.class));
    }

    @Test
    void testNonHeapBuffer(){
        validation(callExample(NonHeapBuffer.class));
    }

    @Test
    void testCloningEntities(){
        validation(callExample(CloningEntities.class));
    }

    @Test
    void testCombinedFunctions(){
        validation(callExample(CombinedFunctions.class));
    }

    @Test
    void testConcurrencySafeDelete(){
        validation(callExample(ConcurrencySafeDelete.class));
    }

    @Test
    void testConcurrencySafeUpdate(){
        validation(callExample(ConcurrencySafeUpdate.class));
    }

    @Test
    void testCountDistinct(){
        validation(callExample(CountDistinct.class));
    }

    @Test
    void testDateFunctions(){
        validation(callExample(DateFunctions.class));
    }

    @Test
    void testFlatPlateExample(){
        validation(callExample(FlatPlateExample.class));
    }

    @Test
    void testGroupBy(){
        validation(callExample(GroupBy.class));
    }

    @Test
    void testHaving(){
        validation(callExample(Having.class));
    }

    @Test
    void testAboveMultiEntity(){
        validation(callExample(AboveMultiEntity.class));
    }

    @Test
    void testInMemoryCascadeSelects(){
        validation(callExample(InMemoryCascadeSelects.class));
    }

    @Test
    void testInMemoryFilterAndMap(){
        validation(callExample(EntitiesStream.class));
    }

    @Test
    void testInMemoryInnerSelect(){
        validation(callExample(InMemoryInnerSelect.class));
    }

    @Test
    void testInMemorySelect(){
        validation(callExample(InMemorySelect.class));
    }

    @Test
    void testInnerSelect(){
        validation(callExample(InnerSelect.class));
    }

    @Test
    void testInsertSelect(){
        assertThrows(DaobabSQLException.class, () -> callExample(InsertSelect.class));
    }

    @Test
    void testJoinLeft(){
        validation(callExample(JoinLeft.class));
    }

    @Test
    void testJoinManyTables(){
        validation(callExample(JoinManyTables.class));
    }

    @Test
    void testJoinPrimaryKeyTable(){
        validation(callExample(JoinPrimaryKeyTable.class));
    }

    @Test
    void testJoinTable(){
        validation(callExample(JoinTable.class));
    }

    @Test
    void testJoinViaDifferentColumns(){
        validation(callExample(JoinViaDifferentColumns.class));
    }

    @Test
    void testJoinWithJoinConditions(){
        validation(callExample(JoinWithJoinConditions.class));
    }

    @Test
    void testLimitOffset(){
        validation(callExample(LimitOffset.class));
    }

    @Test
    void testManyFunctions(){
        validation(callExample(ManyFunctions.class));
    }

    @Test
    void testMinus(){
        validation(callExample(Minus.class));
    }

    @Test
    void testOrderJoinManyTables(){
        validation(callExample(OrderJoinManyTables.class));
    }

    @Test
    void testPagination(){
        validation(callExample(Pagination.class));
    }

    @Test
    void testSelectFromDual(){
        validation(callExample(SelectFromDual.class));
    }

    @Test
    void testSelectNativeManyCells(){
        validation(callExample(SelectNativeManyCells.class));
    }

    @Test
    void testSelectNativeManyEntities(){
        validation(callExample(SelectNativeManyEntities.class));
    }

    @Test
    void testSelectNativeOneEntity(){
        validation(callExample(SelectNativeOneEntity.class));
    }

    @Test
    void testSelectNativePlate(){
        validation(callExample(SelectNativePlate.class));
    }

    @Test
    void testStatistic(){
        assertNull(callExample(Statistic.class));
    }

    @Test
    void testTransactionManual(){
        assertNull(callExample(TransactionManual.class));
    }

    @Test
    void testTransactionWrapper(){
        validation(callExample(TransactionWrapper.class));
    }

    @Test
    void testTransactionWrapperAsynchronous(){
        validation(callExample(TransactionWrapperAsynchronous.class));
    }

    @Test
    void testTransactionWrapperVoid(){
        validation(callExample(TransactionWrapperVoid.class));
    }

    @Test
    void testUnionAll(){
        validation(callExample(UnionAll.class));
    }

    @Test
    void testWhereInAndArrays(){
        validation(callExample(WhereInAndArrays.class));
    }

    @Test
    void testWhereManyCombined(){
        validation(callExample(WhereManyCombined.class));
    }

    @Test
    void testWhereNotNullIsNull(){
        validation(callExample(WhereNotNullIsNull.class));
    }

    @Test
    void testConditionalWhere(){
        validation(callExample(ConditionalWhere.class));
    }

    @Test
    void testConditionIfNotNull(){
        validation(callExample(ConditionIfNotNull.class));
    }

    @Test
    void testE083(){
        validation(callExample(DateTimeConversions.class));
    }

    @Test
    void testMetaDataColumnDatatype(){
        validation(callExample(MetaDataColumnDatatype.class));
    }

    @Test
    void testMetaDataAsQueryTarget(){
        validation(callExample(MetaDataAsQueryTarget.class));
    }

    @Test
    void testMultiEntity(){
        validation(callExample(MultiEntity.class));
    }

    @Test
    void testPrimaryKeyFindManyToManyRelated(){
        validation(callExample(PrimaryKeyFindManyToManyRelated.class));
    }

    @Test
    void testPrimaryKeyFindManyToManyRelatedColumns(){
        validation(callExample(PrimaryKeyFindManyToManyRelatedColumns.class));
    }

    @Test
    void testPrimaryKeyFindOneToOneRelated(){
        validation(callExample(PrimaryKeyFindOneToOneRelated.class));
    }

    @Test
    void testPrimaryKeyFindOneToOneRelatedColumns(){
        validation(callExample(PrimaryKeyFindOneToOneRelatedColumns.class));
    }

    @Test
    void testQueryMultiEntity(){
        validation(callExample(QueryMultiEntity.class));
    }

    @Test
    void testRemotePlate(){
        validation(callExample(RemotePlate.class));
    }

    @Test
    void testRemoteSecurityForbiddenColumns(){
        callExample(RemoteSecurityForbiddenColumns.class);
    }

    @Test
    void testRemoteSecurityForbiddenEntities(){
        validation(callExample(RemoteSecurityForbiddenEntities.class));
    }

    @Test
    void testRemoteSelectManyCells(){
        validation(callExample(RemoteSelectManyCells.class));
    }

    @Test
    void testRemoteSelectManyColumns(){
        validation(callExample(RemoteSelectManyColumns.class));
    }

    @Test
    void testRemoteSelectManyEntities(){
        validation(callExample(RemoteSelectManyEntities.class));
    }

    @Test
    void testRemoteSelectOneEntity(){
        validation(callExample(RemoteSelectOneEntity.class));
    }

    @Test
    void testResultPostProcessor(){
        validation(callExample(ResultPostProcessor.class));
    }

    @Test
    void testTransactionPropagation() {
        validation(callExample(TransactionPropagation.class));
    }

    @Test
    void testSqlInjectionProtection() {
        assertThrows(SqlInjectionDetected.class, () -> callExample(SqlInjectionProtection.class));
    }

    @Test
    void testAbstractQueryAddressRelatedItems() {
        callExample(AbstractQueryAddressRelatedItems.class);
    }

    @Test
    void testAbstractQueryLastRecord() {
        callExample(AbstractQueryLastRecord.class);
    }

    @Test
    void testEagerLoading() {
        callExample(EagerLoading.class);
    }

    @Test
    void testEmbeddedColumns() {
        callExample(EmbeddedColumns.class);
    }

    @Test
    void testAccidentalDeleteProtection() {
        assertThrows(MandatoryWhere.class, () -> callExample(AccidentalDeleteProtection.class));
    }

    @Test
    void testEEnhancedEntity() {
        callExample(EnhancedEntity.class);
    }

    @Test
    void testLinkingEntitiesByWhere() {
        callExample(LinkingEntitiesByWhere.class);
    }
    @Test
    void testOptimisticConcurrencyControlForPrimaryKey() {
        callExample(OptimisticConcurrencyControlForPrimaryKey.class);
    }

    @Test
    void testQueryOptimisation() {
        callExample(QueryOptimisation.class);
    }

    @Test
    void testSchemaComparator() {
        callExample(SchemaComparator.class);
    }

    @Test
    void testQueryModification() {
        callExample(QueryModification.class);
    }

    @Test
    void testFrozenQueryWithParameters() {
        callExample(FrozenQueryWithParameters.class);
    }

    @Test
    void testPrimaryKeyReplace() {
        callExample(PrimaryKeyReplace.class);
    }

    @Test
    void testUnfreezeFrozenQuery() {
        callExample(UnfreezeFrozenQuery.class);
    }

    @Test
    void testInsertDuplicatedKeyUpdate() {
        callExample(InsertDuplicatedKeyUpdate.class);
    }

    @Test
    void testReplaceSelect() {
        callExample(ReplaceSelect.class);
    }

}
