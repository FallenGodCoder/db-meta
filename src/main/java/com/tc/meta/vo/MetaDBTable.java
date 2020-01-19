package com.tc.meta.vo;

import java.io.Serializable;
import java.util.List;

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
public class MetaDBTable implements Serializable {
    private String tableName;
    private String tableCat;
    private String tableSchem;
    private String tableType;
    private String remarks;

    private List<MetaDBTableColumn> metaDBTableColumns;

    public MetaDBTable() {
    }

    public MetaDBTable(String tableName, String tableCat, String tableSchem, String tableType, String remarks) {
        this.tableName = tableName;
        this.tableCat = tableCat;
        this.tableSchem = tableSchem;
        this.tableType = tableType;
        this.remarks = remarks;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableCat() {
        return tableCat;
    }

    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }

    public String getTableSchem() {
        return tableSchem;
    }

    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<MetaDBTableColumn> getMetaDBTableColumns() {
        return metaDBTableColumns;
    }

    public void setMetaDBTableColumns(List<MetaDBTableColumn> metaDBTableColumns) {
        this.metaDBTableColumns = metaDBTableColumns;
    }

    @Override
    public String toString() {
        return "MetaDBTable{" +
                "tableName='" + tableName + '\'' +
                ", tableCat='" + tableCat + '\'' +
                ", tableSchem='" + tableSchem + '\'' +
                ", tableType='" + tableType + '\'' +
                ", remarks='" + remarks + '\'' +
                ", metaDBTableColumns=" + metaDBTableColumns +
                '}';
    }
}
