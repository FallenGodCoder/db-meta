package com.tc.meta.vo;

import java.io.Serializable;

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
  *   descr:  主键列
 */
public class MetaDBPKTableColumn implements Serializable {
    private String tableName;
    private String columnName;
    // 主键名称
    private String pkName;
    // 键序
    private String keySeq;

    public MetaDBPKTableColumn() {
    }

    public MetaDBPKTableColumn(String tableName, String columnName, String pkName, String keySeq) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.pkName = pkName;
        this.keySeq = keySeq;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public String getKeySeq() {
        return keySeq;
    }

    public void setKeySeq(String keySeq) {
        this.keySeq = keySeq;
    }

    @Override
    public String toString() {
        return "MetaDBPKTableColumn{" +
                "tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", pkName='" + pkName + '\'' +
                ", keySeq='" + keySeq + '\'' +
                '}';
    }
}
