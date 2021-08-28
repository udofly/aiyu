package net.liexiang.loveyou.network;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import net.liexiang.loveyou.model.BaseModel;
import net.liexiang.loveyou.model.IModel;
import net.liexiang.loveyou.model.MVVMModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @Author sbqfile
 * @Date 2020-01-29 19:46
 * @Description 接口获取数据的model基类
 **/
public class LxRequest extends BaseModel {


    private static LxRequest instance;

    public LxRequest(MVVMModel mvvmModel) {
        super(mvvmModel);
    }

    public static LxRequest get() {
        if (instance == null) {
            synchronized (LxRequest.class) {
                if (instance == null) {
                    instance = new LxRequest(new MVVMModel() {
                        @Override
                        public <T extends IModel> T getModel(Class<T> modelCls) {
                            return null;
                        }

                        @Override
                        public void onResponse(int requestCode, JSONObject object) {

                        }
                    });
                }
            }
        }
        return instance;
    }

    public <T> T getService(Class<T> service) {
        Retrofit retrofit = HttpConfig.getRetrofit();

        return retrofit.create(service);
    }

    public   <T> RetrofitService getServiceDetail() {
        Retrofit retrofit = HttpConfig.getRetrofit();
        return retrofit.create(RetrofitService.class);
    }

//    protected List<Call<String>> calls = new ArrayList<>();

    public void request(final int requestCode, Call<String> call) {

    }

    public void execute(final int requestCode, Observable<String> observable) {
//        this.calls.add(call);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//
////                Log.d("tag", "response  code=" + response.code());
////                Log.d("tag", "response  message=" + response.message());
////                Log.d("tag", "response  toString=" + response.toString());
//                Log.d("tag", "response =" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("tag", "onFailure =" + t.toString());
//            }
//        });


        // 步骤4：发送网络请求 & 通过repeatWhen（）进行轮询
        observable

//                .repeatWhen(new Function<io.reactivex.Observable<Object>, ObservableSource<?>>() {
//            @Override
//            // 在Function函数中，必须对输入的 Observable<Object>进行处理，此处使用flatMap操作符接收上游的数据
//            public ObservableSource<?> apply(@NonNull io.reactivex.Observable<Object> objectObservable) throws Exception {
//                // 将原始 Observable 停止发送事件的标识（Complete（） /  Error（））转换成1个 Object 类型数据传递给1个新被观察者（Observable）
//                // 以此决定是否重新订阅 & 发送原来的 Observable，即轮询
//                // 此处有2种情况：
//                // 1. 若返回1个Complete（） /  Error（）事件，则不重新订阅 & 发送原来的 Observable，即轮询结束
//                // 2. 若返回其余事件，则重新订阅 & 发送原来的 Observable，即继续轮询
//                return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(@NonNull Object throwable) throws Exception {
//                        return Observable.just(1);
//                    }
//                });
//
//            }
//        })

                .subscribeOn(Schedulers.io()) //请求数据的事件发生在io线程
                .observeOn(AndroidSchedulers.mainThread())  // 切换回到主线程 处理请求结果
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        // e.接收服务器返回的数据
                        Log.d("tag", "result = " + result);


                        if (getMVVMModel() != null) {
                            getMVVMModel().onResponse(requestCode, JSONObject.parseObject(result));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 获取轮询结束信息
                        Log.d("tag", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    public RequestBody getJsonBody(String json) {


        Log.d("tag", "json = " + json);

        return RequestBody.create(MediaType.parse("application/json"), json);
    }
}

