package net.liexiang.loveyou.rxjava;

public interface RxApiCallback<T> {
    void onSuccess(T model);

    void onFailure(int code, String msg);

}