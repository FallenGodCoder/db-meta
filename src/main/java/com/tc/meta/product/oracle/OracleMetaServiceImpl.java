package com.tc.meta.product.oracle;

import com.tc.meta.DefaultDBMetaServiceImpl;
import com.tc.meta.vo.MetaDBInfo;
import oracle.jdbc.internal.OracleConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
  *                    _ooOoo_
  *                   o8888888o
  *                   88" . "88
  *                   (| -_- |)
  *                   O\  =  /O
  *                ____/`---'\____
  *              .'  \\|     |//  `.
  *             /  \\|||  :  |||//  \
  *            /  _||||| -:- |||||-  \
  *            |   | \\\  -  /// |   |
  *            | \_|  ''\---/''  |   |
  *            \  .-\__  `-`  ___/-. /
  *          ___`. .'  /--.--\  `. . __
  *       ."" '<  `.___\_<|>_/___.'  >'"".
  *      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
  *      \  \ `-.   \_ __\ /__ _/   .-` /  /
  * ======`-.____`-.___\_____/___.-`____.-'======
  *                    `=---='
  * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  *          佛祖保佑       永无BUG
  *  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  *   author: tangcheng_cd
  *   create by: 2020/1/19
  *   descr: 
 */
public class OracleMetaServiceImpl extends DefaultDBMetaServiceImpl {
    public OracleMetaServiceImpl(MetaDBInfo metaDBInfo) {
        super(metaDBInfo);
    }

    public String getSchema(Connection connection, DatabaseMetaData metaData) throws SQLException {
        return ((OracleConnection) connection).getDefaultSchemaNameForNamedTypes();
    }
}
