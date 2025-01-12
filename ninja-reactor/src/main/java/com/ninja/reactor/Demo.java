package com.ninja.reactor;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2024/9/29
 */
public class Demo {

    public static void main(String[] args) {
        Mono<String> just = Mono.just("1");
        CoreSubscriber<String> stringCoreSubscriber = new CoreSubscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                System.out.println("Received:" + s);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        };
        just.subscribe(stringCoreSubscriber);
    }
}
