package com.cmbchina.contains;

/**
 * Created by ninja on 2019/12/7
 */
public interface RabbitRelationContaints {

    String ORDER_TOPIC_KEY = "order.success.ninja";

    String ORDER_SUCCESS_BIINDING_KEY = "order.#";

    String ORDER_FAIL_BIINDING_KEY = "order.*";

    String NINJA_EXCHANGE_01 = "ninja.exchange01";

    String NINJA_ORDER_SUCCESS_QUEUE = "ninja.order.success.queue";

    String NINJA_ORDER_FAIL_QUEUE = "ninja.order.fail.queue";

    String ORDER_DLX_QUEUE = "order.dlx.queue";
}
