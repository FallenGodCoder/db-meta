package com.tc.meta;

import com.tc.meta.vo.*;

import java.util.List;

/**
 * 数据库元数据服务
 */
public interface DBMetaService {

    /**
     * 获取元数据库产品信息
     *
     * @return
     */
    MetaDBProductInfo getMetaDBProductInfo();

    /**
     * 获取所有的catalogs
     *
     * @return
     */
    List<String> getCatalogs();

    /**
     * 获取所有的Schemas
     *
     * @return
     */
    List<String> getSchemas();

    /**
     *  获取表的所有类型
     * @return
     */
    List<String> getTableTypes();

    /**
     * 获取所有的表
     *
     * @return
     */
    List<MetaDBTable> getTables();

    /**
     * 获取所有的表列信息
     *
     * @return
     */
    List<MetaDBTable> getTableColumn ();

    /**
     * 获取给定表名下的所有列
     *
     * @param tableName 表名条件
     * @return
     */
    List<MetaDBTableColumn> getTableColumnByTableName(String tableName);

    /**
     * 获取所有函数
     */
    List<MetaDBFunction> getFunctions();

    /**
     * 获取数据库的存储过程
     */
    List<MetaDbProcedure> getProcedures();

    /**
     * 获取表的主键列
     *
     * @param tableNameParam
     * @return
     */
    List<MetaDBPKTableColumn> getPrimaryColumn(String tableNameParam);

    /**
     * 获取索引信息
     */
    List<MetaDBIndex> getIndexInfo(String tableNameParam);
}
