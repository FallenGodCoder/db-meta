package com.tc.meta.util;

import com.tc.meta.vo.MetaDBInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MetaDBHelper {
    private MetaDBHelper() {
    }

    /**
     * 数据数据库连接
     *
     * @param metaDBInfo 源数据数据库信息
     * @return
     * @throws SQLException
     */
    public static Connection getConnection (MetaDBInfo metaDBInfo) throws SQLException {
        try {
            String dirverClass = metaDBInfo.getDirverClass();
            Class.forName(dirverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = metaDBInfo.getUrl();
        String userName = metaDBInfo.getUserName();
        String password = metaDBInfo.getPassword();

        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * 释放连接
     * @param connection
     */
    public static void releaseConnection(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
