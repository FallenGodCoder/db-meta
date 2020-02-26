package com.tc.meta;

import com.tc.meta.product.db2.Db2MetaServiceImpl;
import com.tc.meta.product.mysql.MySQLMetaServiceImpl;
import com.tc.meta.product.oracle.OracleMetaServiceImpl;
import com.tc.meta.vo.MetaDBInfo;

public class DBMetaServiceFactory {
    private static DBMetaServiceFactory ourInstance = new DBMetaServiceFactory();

    public static DBMetaServiceFactory getInstance() {
        return ourInstance;
    }

    private DBMetaServiceFactory() {
    }

    /**
     * 获取元数据服务
     *
     * @param metaDBInfo
     * @return
     */
    public DBMetaService getService (MetaDBInfo metaDBInfo) {
        String dbType = metaDBInfo.getDbType();
        if ("Oracle".equals(dbType)) {
            return new OracleMetaServiceImpl(metaDBInfo);
        }
        if ("MySQL".equals(dbType)) {
            return new MySQLMetaServiceImpl(metaDBInfo);
        }
        if ("DB2".equals(dbType)) {
            return new Db2MetaServiceImpl(metaDBInfo);
        }
        return new DefaultDBMetaServiceImpl(metaDBInfo);
    }
}
