//package net.liexiang.loveyou.rxjava;
//
//import android.database.Observable;
//
//import org.reactivestreams.Subscriber;
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class RxManager {
//
//    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();// 管理订阅者者
//
//    //添加订阅者
//    public void add(Observable observable, Subscriber subscriber) {
//        mCompositeSubscription.add(
//                observable
//                        .subscribeOn(Schedulers.io())//设置调用方法前在io线程中执行
//                        .unsubscribeOn(Schedulers.io())//设置取消订阅在io线程中执行
//                        .observeOn(AndroidSchedulers.mainThread())//设置调用方法后在主线程中执行
//                        .subscribe(subscriber));//设置订阅者
//    }
//   // 取消所有订阅者
//    public void clear() {
//        mCompositeSubscription.unsubscribe();// 取消订阅
//    }
//}