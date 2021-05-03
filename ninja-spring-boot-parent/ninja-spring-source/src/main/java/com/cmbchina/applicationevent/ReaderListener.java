package com.cmbchina.applicationevent;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

/**
 * 观察者：读者粉丝
 *
 * @Desc
 * @Author ninja
 * @Date Created on 2021/4/15
 */
@RequiredArgsConstructor
public class ReaderListener implements ApplicationListener<JavaStackEvent> {

    @NonNull
    private String name;

    private String article;

    @Async
    @Override
    public void onApplicationEvent(JavaStackEvent event) {
        //更新文章
        updateArticle(event);
    }

    private void updateArticle(JavaStackEvent event) {
        this.article = (String) event.getSource();
        System.out.printf("我是读者：%s,文章已更新为：%s\n", this.name, this.article);
    }
}
