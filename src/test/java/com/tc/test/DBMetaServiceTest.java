package com.tc.test;

import com.google.common.base.Joiner;
import com.tc.meta.DBMetaService;
import com.tc.meta.DBMetaServiceFactory;
import com.tc.meta.vo.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DBMetaServiceTest {
    DBMetaService dbMetaService;
    MetaDBInfo metaDBInfo;

    private MetaDBInfo getMysqlDbMetaInfo () {
        MetaDBInfo metaDBInfo = new MetaDBInfo();
        metaDBInfo.setDirverClass("com.mysql.cj.jdbc.Driver");
        metaDBInfo.setDbType("MySQL");
        metaDBInfo.setUrl("jdbc:mysql://192.168.20.252:3306/deepwater?serverTimezone=UTC&autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false");
        metaDBInfo.setUserName("root");
        metaDBInfo.setPassword("12345678");

        return metaDBInfo;
    }

    private MetaDBInfo getOracleMetaInfo () {
        MetaDBInfo metaDBInfo = new MetaDBInfo();
        metaDBInfo.setDirverClass("oracle.jdbc.driver.OracleDriver");
        metaDBInfo.setDbType("Oracle");
        metaDBInfo.setUrl("jdbc:oracle:thin:@192.168.20.38:1521:kfdb");
        metaDBInfo.setUserName("td");
        metaDBInfo.setPassword("password");

        return metaDBInfo;
    }

    @Before
    public void before() {
        metaDBInfo = this.getOracleMetaInfo();
//        metaDBInfo = this.getMysqlDbMetaInfo();

        DBMetaServiceFactory dbMetaServiceFactory = DBMetaServiceFactory.getInstance();
        dbMetaService = dbMetaServiceFactory.getService(metaDBInfo);
    }

    @Test
    public void TestAllNormal () { // 测试常用接口
        System.out.println("=========getMetaDBProductInfo============");
        this.getMetaDBProductInfo();

        System.out.println("=========getCatalogs============");
        this.getCatalogs();

        System.out.println("=========getSchemas============");
        this.getSchemas();

        System.out.println("=========getTableTypes============");
        this.getTableTypes();

        System.out.println("=========getTableColumn============");
        this.getTableColumn();

        System.out.println("=========getFunctions============");
        this.getFunctions();

        System.out.println("=========getProcedures============");
        this.getProcedures();

        System.out.println("=========getPrimaryColumn============");
        this.getPrimaryColumn();

        System.out.println("=========getIndexInfo============");
        this.getIndexInfo();
    }

    @Test
    public void getMetaDBProductInfo () {
        MetaDBProductInfo metaDBProductInfo = dbMetaService.getMetaDBProductInfo();

        System.out.println(metaDBProductInfo);
    }

    @Test
    public void getTableTypes() {
        List<String> tableTypes = dbMetaService.getTableTypes();
        String resultStr = Joiner.on("\r\n").join(tableTypes);

        System.out.println("\r\ntableTypes:");
        System.out.println(resultStr);
    }

    @Test
    public void getTables() {
        List<MetaDBTable> tables = dbMetaService.getTables();
        for (MetaDBTable table : tables) {
            System.out.println(table);
        }
    }

    @Test
    public void getTableColumnByTableName() {
        // 表名列名在有些数据库中区分大小写
//        String tableName = "T_SYS_USER"; // 这个表我的oralce中有
        String tableName = "dw_plugin_info"; // 这个表我的mysql中有
        List<MetaDBTableColumn> tableColumns = dbMetaService.getTableColumnByTableName(tableName);
        for (MetaDBTableColumn tableColumn : tableColumns) {
            System.out.println(tableColumn);
        }
    }

    @Test
    public void getTableColumn() {
        List<MetaDBTable> tables = dbMetaService.getTableColumn();

        System.out.println("========================");
        for (MetaDBTable table : tables) {
            System.out.println(table);
            System.out.println("-------列---------");
            for (MetaDBTableColumn metaDBTableColumn : table.getMetaDBTableColumns()) {
                System.out.println(metaDBTableColumn);
            }
            System.out.println("========================");
        }
    }

    @Test
    public void getCatalogs() {
        // 这个catalogs在mysql中有，oracle中没有
        List<String> catalogs = dbMetaService.getCatalogs();
        System.out.println("catalogs:");
        for (String catalog : catalogs) {
            System.out.println("\t" + catalog);
        }
    }

    @Test
    public void getSchemas() {
        // 这个schema在oracle中有，mysql中没有
        List<String> schemas = dbMetaService.getSchemas();
        System.out.println("schemas:");
        for (String schema : schemas) {
            System.out.println("\t" + schema);
        }
    }

    @Test
    public void getFunctions () {
        List<MetaDBFunction> functions = dbMetaService.getFunctions();
        System.out.println("functions:");
        for (MetaDBFunction function : functions) {
//            System.out.println(function);
            System.out.println(function.getFunctionName());
        }
    }

    @Test
    public void getProcedures () {
        List<MetaDbProcedure> procedures = dbMetaService.getProcedures();
        System.out.println("procedure:");
        for (MetaDbProcedure procedure : procedures) {
            System.out.println("\t" + procedure.getProcedureName());
        }
    }

    @Test
    public void getPrimaryColumn () {
        List<MetaDBPKTableColumn> list = dbMetaService.getPrimaryColumn("T_SYS_ORG_INFO");
        System.out.println("getPrimaryColumn:");
        for (MetaDBPKTableColumn metaDBPKTableColumn : list) {
            System.out.println(metaDBPKTableColumn);
        }
    }

    @Test
    public void getIndexInfo () {
        List<MetaDBIndex> list = dbMetaService.getIndexInfo("T_SYS_ORG_INFO");
        System.out.println("getIndexInfo");
        for (MetaDBIndex metaDBIndex : list) {
            System.out.println(metaDBIndex);
        }
    }
}
