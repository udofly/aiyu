package net.liexiang.loveyou.network;

import org.reactivestreams.Subscriber;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

public abstract class FilterSubscriber<T> implements Subscriber<T> {
    public String error;

    @Override
    public abstract void onComplete();

    @Override
    public void onError(Throwable e) {
        if (e instanceof TimeoutException || e instanceof SocketTimeoutException
                || e instanceof ConnectException) {
            error = "超时了";
        } else {
            error = e.getMessage();
        }
    }
}