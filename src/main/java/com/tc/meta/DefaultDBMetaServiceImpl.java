package com.tc.meta;

import com.tc.meta.util.MetaDBHelper;
import com.tc.meta.vo.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\  =  /O
 * ____/`---'\____
 * .'  \\|     |//  `.
 * /  \\|||  :  |||//  \
 * /  _||||| -:- |||||-  \
 * |   | \\\  -  /// |   |
 * | \_|  ''\---/''  |   |
 * \  .-\__  `-`  ___/-. /
 * ___`. .'  /--.--\  `. . __
 * ."" '<  `.___\_<|>_/___.'  >'"".
 * | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * \  \ `-.   \_ __\ /__ _/   .-` /  /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 佛祖保佑       永无BUG
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * author: tangcheng_cd
 * create by: 2020/1/19
 * descr: 默认关系型数据库元数据服务实现
 */
public class DefaultDBMetaServiceImpl implements DBMetaService {
    private MetaDBInfo metaDBInfo;

    public DefaultDBMetaServiceImpl(MetaDBInfo metaDBInfo) {
        this.metaDBInfo = metaDBInfo;
    }

    @Override
    public MetaDBProductInfo getMetaDBProductInfo() {
        Connection conn = null;
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            MetaDBProductInfo metaDBProductInfo = new MetaDBProductInfo();

            try {
                metaDBProductInfo.setProductName(metaData.getDatabaseProductName());
            } catch (SQLException e) {}

            try {
                metaDBProductInfo.setProductVersion(metaData.getDatabaseProductVersion());
            } catch (SQLException e) {}

            try {
                metaDBProductInfo.setMajorVersion(String.valueOf(metaData.getDatabaseMajorVersion()));
            } catch (SQLException e) {}

            return metaDBProductInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return null;
    }

    @Override
    public List<String> getCatalogs() {
        Connection conn = null;
        List<String> catalogList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            ResultSet catalogRs = metaData.getCatalogs();
            while (catalogRs.next()) {
                String catalog = catalogRs.getString(1);
                catalogList.add(catalog);
            }
            catalogRs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }

        return catalogList;
    }

    @Override
    public List<String> getSchemas() {
        Connection conn = null;
        List<String> schemaList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            ResultSet schemaRs = metaData.getSchemas();
            while (schemaRs.next()) {
                String catalog = schemaRs.getString(1);
                schemaList.add(catalog);
            }
            schemaRs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }

        return schemaList;
    }

    @Override
    public List<String> getTableTypes() {
        Connection conn = null;
        List<String> tableTypeList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            ResultSet tableTypeRS = metaData.getTableTypes();
            while (tableTypeRS.next()) {
                String tableType = tableTypeRS.getString(1);
                tableTypeList.add(tableType);
            }
            tableTypeRS.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return tableTypeList;
    }

    public String getSchema(Connection connection, DatabaseMetaData metaData) throws SQLException {
        return connection.getSchema();
    }

    @Override
    public List<MetaDBTable> getTables() {
        Connection conn = null;
        List<MetaDBTable> metaDbTableList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet tables = metaData.getTables(catalog,
                    schema,
                    null,
                    new String[]{"TABLE", "VIEW"}
            );
            while (tables.next()) {
                String tableName = tables.getString("table_name");
                String tableCat = tables.getString("table_cat");
                String tableSchem = tables.getString("table_schem");
                String tableType = tables.getString("table_type");
                String remarks = tables.getString("remarks");

                metaDbTableList.add(new MetaDBTable(tableName, tableCat, tableSchem, tableType, remarks));
            }

            tables.close();
            return metaDbTableList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return null;
    }

    @Override
    public List<MetaDBTable> getTableColumn() {
        Connection conn = null;
        List<MetaDBTable> metaDbTableList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet tables = metaData.getTables(catalog,
                    schema,
                    null,
                    new String[]{"TABLE", "VIEW"}
            );
            while (tables.next()) {
                String tableName = tables.getString("table_name");
                String tableCat = tables.getString("table_cat");
                String tableSchem = tables.getString("table_schem");
                String tableType = tables.getString("table_type");
                String remarks = tables.getString("remarks");

                MetaDBTable metaDBTable = new MetaDBTable(tableName, tableCat, tableSchem, tableType, remarks);

                ResultSet columns = metaData.getColumns(catalog, schema, tableName, null);
                List<MetaDBTableColumn> metaDbTableColumnList = new ArrayList();
                while (columns.next()) {
                    String tableNameStr = columns.getString("table_name");
                    String columnName = columns.getString("column_name");
                    String typeName = columns.getString("type_name");
                    String columnSize = columns.getString("column_size");
                    String columnRemarks = columns.getString("remarks");

                    MetaDBTableColumn metaDBTableColumn = new MetaDBTableColumn(tableNameStr, columnName, typeName, columnSize, columnRemarks);
                    metaDbTableColumnList.add(metaDBTableColumn);
                }

                metaDBTable.setMetaDBTableColumns(metaDbTableColumnList);
                metaDbTableList.add(metaDBTable);

                columns.close();
            }

            tables.close();
            return metaDbTableList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return null;
    }

    @Override
    public List<MetaDBTableColumn> getTableColumnByTableName(String tableName) {
        Connection conn = null;
        List<MetaDBTableColumn> metaDbTableColumnList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet columns = metaData.getColumns(catalog, schema, tableName, null);
            while (columns.next()) {
                String tableNameStr = columns.getString("table_name");
                String columnName = columns.getString("column_name");
                String typeName = columns.getString("type_name");
                String columnSize = columns.getString("column_size");
                String remarks = columns.getString("remarks");

                metaDbTableColumnList.add(new MetaDBTableColumn(tableNameStr, columnName, typeName, columnSize, remarks));
            }

            columns.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return metaDbTableColumnList;
    }

    @Override
    public List<MetaDBFunction> getFunctions() {
        Connection conn = null;
        List<MetaDBFunction> resultList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet functionRs = metaData.getFunctions(catalog, schema, null);

            while (functionRs.next()) {
                String functionCat = functionRs.getString("function_cat");
                String functionSchem = functionRs.getString("function_schem");
                String functionName = functionRs.getString("function_name");
                String remarks = functionRs.getString("remarks");
                String functionType = functionRs.getString("function_type");
                String specificName = functionRs.getString("specific_name");

                resultList.add(new MetaDBFunction(functionCat, functionSchem, functionName, remarks, functionType, specificName));
            }

            functionRs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }

        return resultList;
    }

    @Override
    public List<MetaDbProcedure> getProcedures() {
        Connection conn = null;
        List<MetaDbProcedure> resultList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet procedureRs = metaData.getProcedures(catalog, schema, null);

            while (procedureRs.next()) {
                String procedureCat = procedureRs.getString("procedure_cat");
                String procedureSchem = procedureRs.getString("procedure_schem");
                String procedureName = procedureRs.getString("procedure_name");
                String remarks = procedureRs.getString("remarks");
                String procedureType = procedureRs.getString("procedure_type");

                resultList.add(new MetaDbProcedure(procedureCat, procedureSchem, procedureName, remarks, procedureType));
            }

            procedureRs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return resultList;
    }

    @Override
    public List<MetaDBPKTableColumn> getPrimaryColumn(String tableNameParam) {
        Connection conn = null;
        List<MetaDBPKTableColumn> resultList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet primaryKeyRs = metaData.getPrimaryKeys(catalog, schema, tableNameParam);

            while (primaryKeyRs.next()) {
                String tableName = primaryKeyRs.getString("table_name");
                String columnName = primaryKeyRs.getString("column_name");
                String pkName = primaryKeyRs.getString("pk_name");
                String keySeq = primaryKeyRs.getString("key_seq");

                resultList.add(new MetaDBPKTableColumn(tableName, columnName, pkName, keySeq));
            }

            primaryKeyRs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }

        return resultList;
    }

    @Override
    public List<MetaDBIndex> getIndexInfo(String tableNameParam) {
        Connection conn = null;
        List<MetaDBIndex> resultList = new ArrayList();
        try {
            conn = MetaDBHelper.getConnection(metaDBInfo);
            DatabaseMetaData metaData = conn.getMetaData();

            String catalog = conn.getCatalog();
            String schema = getSchema(conn, metaData);

            ResultSet indexRs = metaData.getIndexInfo(catalog, schema, tableNameParam, false, false);

            while (indexRs.next()) {
                String tableCat = indexRs.getString("table_cat");
                String tableSchem = indexRs.getString("table_schem");
                String tableName = indexRs.getString("table_name");
                String columnName = indexRs.getString("column_name");
                String indexName = indexRs.getString("index_name");

                resultList.add(new MetaDBIndex(tableCat, tableSchem, tableName, columnName, indexName));
            }

            indexRs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MetaDBHelper.releaseConnection(conn);
        }
        return resultList;
    }

//    TODO:: 还可以继续实现：
//    metaData.getImportedKeys();
//    metaData.getExportedKeys();
}
