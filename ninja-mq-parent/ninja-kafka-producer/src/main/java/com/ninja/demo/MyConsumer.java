package com.ninja.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by ninja on 2020/2/10
 */
@Component
public class MyConsumer {

    /**
     * @param record
     * @KafkaListener(groupId = "testGroup", topicPartitions = {
     * @TopicPartition(topic = "topic1", partitions = {"0", "1"}),
     * @TopicPartition(topic = "topic2", partitions = "0",
     * partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))
     * },concurrency = "6")
     * //concurrency就是同组下的消费者个数，就是并发消费数，必须小于等于分区总数
     */
    @KafkaListener(topics = "mytopic", group = "testGroup")
    public void listen(ConsumerRecord<String, String> record) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
    }
}
