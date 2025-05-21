package com.ninja.cdc;

import com.ververica.cdc.connectors.mysql.source.MySqlSource;
import com.ververica.cdc.connectors.mysql.table.StartupOptions;
import com.ververica.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2025/2/22
 */
public class DataStream {

    public static void main(String[] args) throws Exception {
        //1.获取flink执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //2.开启CheckPoint
        env.enableCheckpointing(5000L);
        env.getCheckpointConfig().setCheckpointTimeout(10000L);
        env.getCheckpointConfig().setCheckpointStorage("hdfs://hadoop102:8020/flinkcdc/ck");
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(1);


        //3.使用flinkcdc构建mysqlsource
        MySqlSource<String> mysqlSource = MySqlSource.<String>builder()
                .hostname("localhost")
                .port(3306)
                .username("root")
                .password("1234")
                .databaseList("cdc_source")
                .tableList("cdc_source.t1")
                .startupOptions(StartupOptions.initial())
                .deserializer(new JsonDebeziumDeserializationSchema())
                .build();

        //4.读取数据
        DataStreamSource<String> source = env.fromSource(
                mysqlSource,
                WatermarkStrategy.noWatermarks(),
                "Mysql Source");

        //5.打印
        source.print();
        //6.启动
        env.execute("Flink MySQL CDC");

    }
}
