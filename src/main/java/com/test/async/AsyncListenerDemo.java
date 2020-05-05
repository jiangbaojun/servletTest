package com.test.async;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequest;
import java.io.IOException;

/**
 * 异步任务监听
 * @Author: jiangbaojun
 */
public class AsyncListenerDemo implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        ServletRequest suppliedRequest = event.getSuppliedRequest();
        System.out.println("异步任务-onComplete");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("异步任务-onTimeout");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("异步任务-onError");
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("异步任务-onStartAsync");
    }
}
