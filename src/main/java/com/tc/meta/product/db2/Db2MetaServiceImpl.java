package com.tc.meta.product.db2;

import com.tc.meta.DefaultDBMetaServiceImpl;
import com.tc.meta.vo.MetaDBInfo;
import com.ibm.db2.jcc.t4.b;

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
  *   create by: 2020/2/26
  *   descr: 
 */
public class Db2MetaServiceImpl extends DefaultDBMetaServiceImpl {
    public Db2MetaServiceImpl(MetaDBInfo metaDBInfo) {
        super(metaDBInfo);
    }

    @Override
    public String getSchema(Connection connection, DatabaseMetaData metaData) throws SQLException {
        return ((b) connection).getDatabaseName();
    }
}
