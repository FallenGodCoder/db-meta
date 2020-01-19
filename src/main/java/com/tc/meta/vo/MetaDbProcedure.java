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
  *   descr:  存储过程信息
 */
public class MetaDbProcedure implements Serializable {
    private String procedureCat;
    private String procedureSchem;
    private String procedureName;
    private String remarks;
    // 存储过程类型   1：存储过程   2： 函数
    private String procedureType;

    public MetaDbProcedure() {
    }

    public MetaDbProcedure(String procedureCat, String procedureSchem, String procedureName, String remarks, String procedureType) {
        this.procedureCat = procedureCat;
        this.procedureSchem = procedureSchem;
        this.procedureName = procedureName;
        this.remarks = remarks;
        this.procedureType = procedureType;
    }

    public String getProcedureCat() {
        return procedureCat;
    }

    public void setProcedureCat(String procedureCat) {
        this.procedureCat = procedureCat;
    }

    public String getProcedureSchem() {
        return procedureSchem;
    }

    public void setProcedureSchem(String procedureSchem) {
        this.procedureSchem = procedureSchem;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    @Override
    public String toString() {
        return "MetaDbProcedure{" +
                "procedureCat='" + procedureCat + '\'' +
                ", procedureSchem='" + procedureSchem + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", procedureType='" + procedureType + '\'' +
                '}';
    }
}
