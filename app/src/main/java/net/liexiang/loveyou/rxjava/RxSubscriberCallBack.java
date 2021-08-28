package net.liexiang.loveyou.rxjava;

import net.liexiang.loveyou.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RxSubscriberCallBack<T> implements Subscriber<T> {
    private RxApiCallback<T> rxApiCallback;
    public RxSubscriberCallBack(RxApiCallback<T> mapiCallbackRx){
        this.rxApiCallback = mapiCallbackRx;
    }
    @Override
    public void onComplete(){//事件队列中没有后续事件

    }
    @Override
    public void onError(Throwable e) {//获取服务器信息失败
        e.printStackTrace();
//        //网络
//        if (!NetWorkUtils.isNetConnected(App.getAppContext())) {//是否无网络
//            rxApiCallback.onFailure(0, RescourseUtils.getString(R.string.no_net));
//        }
//        //服务器
//        else{
//            rxApiCallback.onFailure(1, "获取数据失败");
//        }
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {//成功时回调
            rxApiCallback.onSuccess(t);

    }
}