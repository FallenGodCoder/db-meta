package com.tc.test;

import schemacrawler.crawl.SchemaCrawler;
import schemacrawler.schema.*;
import schemacrawler.schemacrawler.*;
import schemacrawler.utility.SchemaCrawlerUtility;

import java.sql.Connection;
import java.sql.DriverManager;
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
  *   create by: 2020/1/17
  *   descr: 
 */
public class SchemaCrawlerTest {
    public static Connection getMysqlConnection () throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://192.168.20.252:3306/deepwater?serverTimezone=UTC&autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false";

        return DriverManager.getConnection(url, "root", "12345678");
    }

    public static Connection getOracleConnection () throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@192.168.20.38:1521:kfdb";

        return DriverManager.getConnection(url, "td", "password");
    }

    public static void main(String[] args) throws SQLException, SchemaCrawlerException {
        // Create the options
        final SchemaCrawlerOptionsBuilder optionsBuilder =
                SchemaCrawlerOptionsBuilder.builder()
                        // Set what details are required in the schema - this affects the
                        // time taken to crawl the schema
                        .withSchemaInfoLevel(SchemaInfoLevelBuilder.maximum())
//                        .includeSchemas(new RegularExpressionInclusionRule("TD.*"));
                        .includeSchemas(new RegularExpressionInclusionRule("TD"));
//                        .includeTables(tableFullName -> !tableFullName.contains("bigdata"));
        final SchemaCrawlerOptions options = optionsBuilder.toOptions();

        // Get the schema definition
        Connection connection = getOracleConnection();
        SchemaRetrievalOptions schemaRetrievalOptions = SchemaCrawlerUtility.matchSchemaRetrievalOptions(connection);
        SchemaCrawler schemaCrawler = new SchemaCrawler(connection, schemaRetrievalOptions, options);

        final Catalog catalog = SchemaCrawlerUtility.getCatalog(getOracleConnection(), options);

        for (final Schema schema : catalog.getSchemas())
        {
            System.out.println(schema);
            for (final Table table : catalog.getTables(schema))
            {
                System.out.print("o--> " + table);
                if (table instanceof View)
                {
                    System.out.println(" (VIEW)");
                }
                else
                {
                    System.out.println();
                }

                for (final Column column : table.getColumns())
                {
                    System.out.println(
                            "     o--> " + column + " (" + column.getColumnDataType() + ")");
                }
            }
        }

    }
}
