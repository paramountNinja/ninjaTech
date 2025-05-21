package com.ninja.cdc;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2025/2/22
 */
public class SQL {

    public static void main(String[] args) {
        //1.获取flink执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);

        //2.使用flinkCDC SQL方式建表
        tableEnv.executeSql("" +
                "CREATE TABLE tt (\n" +
                "     id string primary key NOT ENFORCED,\n" +
                "     name string\n" +
                "     ) WITH (\n" +
                "     'connector' = 'mysql-cdc',\n" +
                "     'hostname' = 'localhost',\n" +
                "     'port' = '3306',\n" +
                "     'username' = 'root',\n" +
                "     'password' = '1234',\n" +
                "     'database-name' = 'cdc_source',\n" +
                "     'table-name' = 't1');");

        //3.查询并打印
        Table table = tableEnv.sqlQuery("select * from tt");
        table.execute().print();
    }
}
