package com.tc.test.config;

import com.tc.meta.vo.MetaDBInfo;

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
public class DatabaseMetaInfoProvider {

    public static MetaDBInfo getMysqlDbMetaInfo () {
        MetaDBInfo metaDBInfo = new MetaDBInfo();
        metaDBInfo.setDirverClass("com.mysql.cj.jdbc.Driver");
        metaDBInfo.setDbType("MySQL");
        metaDBInfo.setUrl("jdbc:mysql://192.168.20.252:3306/deepwater?serverTimezone=UTC&autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false");
        metaDBInfo.setUserName("root");
        metaDBInfo.setPassword("12345678");

//        metaDBInfo.setUrl("jdbc:mysql://localhost:3306/deepwater?serverTimezone=UTC&autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false");
//        metaDBInfo.setUserName("deepwater");
//        metaDBInfo.setPassword("deepwater");

        return metaDBInfo;
    }

    public static MetaDBInfo getOracleMetaInfo () {
        MetaDBInfo metaDBInfo = new MetaDBInfo();
        metaDBInfo.setDirverClass("oracle.jdbc.driver.OracleDriver");
        metaDBInfo.setDbType("Oracle");
        metaDBInfo.setUrl("jdbc:oracle:thin:@192.168.20.38:1521:kfdb");
        metaDBInfo.setUserName("td");
        metaDBInfo.setPassword("password");

        return metaDBInfo;
    }

    public static MetaDBInfo getDb2MetaInfo() {
        MetaDBInfo metaDBInfo = new MetaDBInfo();
        metaDBInfo.setDirverClass("com.ibm.db2.jcc.DB2Driver");

        metaDBInfo.setUrl("jdbc:db2://192.168.56.2:50000/DMC:currentSchema=DMC;");
        metaDBInfo.setUserName("db2inst1");
        metaDBInfo.setPassword("db2inst1");
        metaDBInfo.setDbType("DB2");

        return metaDBInfo;
    }
}
