package net.liexiang.loveyou;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import net.liexiang.loveyou.network.DataPresenter;
import net.liexiang.loveyou.network.LxRequest;
import net.liexiang.loveyou.network.ModelPresenter;
import net.liexiang.loveyou.network.ModelPresenterImpl;
import net.liexiang.loveyou.network.RetrofitService;
import net.liexiang.loveyou.utils.EncryptUtils;
import net.liexiang.loveyou.utils.StringSort;
import net.liexiang.loveyou.utils.StringUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private DataPresenter mDataPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarUtils.setStatusBarVisibility(this, false);
//        BarUtils.setNotificationBarVisibility(false);
//        ModelPresenterImpl
        get_SystemInfo();

    }


//    public void get_SystemInfo22() {
//        Map<String, Object> param = new HashMap<>();
//        param.put("price_start", "800");
//        param.put("price_end", "1000");
//
//
//        Observable<String> observable = ModelPresenter.g("bt_app_ios", "9c1e6634ce1c5098e056628cd66a17a5", 1346);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new FilterSubscriber<TopicData>() {
//                    @Override
//                    public void onCompleted() {
//                        MLog.d("Topic信息下载完毕");
//                    }
//                    @Override
//                    public void onNext(TopicData data) {
//                        mMainView.showSuccess(data);
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        mMainView.showError(error);
//                    }
//                });
//
//
//    }

    public void get_SystemInfo() {
        Map<String, Object> param = new HashMap<>();
        param.put("price_start", "800");
        param.put("price_end", "1000");
        LxRequest.get().execute(1, LxRequest.get().getServiceDetail().getSystemInfo2(param));
    }

    public void getUserInfo() {
        Map<String, Object> param = new HashMap<>();
        param.put("version", "9.9.9");
        param.put("timestamp", "1618542586653");
        param.put("sign", getSign(this, JSONObject.parseObject(GsonUtils.toJson(param)), ""));


//        LxRequest.get().execute(1, LxRequest.get().getService(RetrofitService.class).getSystemInfo(LxRequest.get().getJsonBody(GsonUtils.toJson(param))));
        LxRequest.get().execute(1, LxRequest.get().getService(RetrofitService.class).getSystemInfo2(param));
    }

    /**
     * 获取sign加密后的字符串
     */
    public static String getSign(Context context, JSONObject object, String myToken) {
        Log.d("tag", "on = " + object.toString());
        String sign      = "";
        String sort      = StringSort.sort(object);
        String MD5_1     = EncryptUtils.encrypt("MD5", sort);
        String sort2     = MD5_1 + myToken;
        String sign_temp = EncryptUtils.encrypt("MD5", sort2);

        String sort3 = sign_temp + "android" + getCurrentVersionName(context);
        sign_temp = EncryptUtils.encrypt("MD5", sort3);
        String firstNum = "";
        String lastChar = "";

        for (int i = 0; i < sign_temp.length(); i++) {
            if (sign_temp.charAt(i) >= 48 && sign_temp.charAt(i) <= 57) {
                firstNum = String.valueOf(sign_temp.charAt(i));
                break;
            }
        }
        for (int i = sign_temp.length() - 1; i >= 0; i--) {
            char c = sign_temp.charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                lastChar = String.valueOf(c);
                break;
            }
        }

        if (StringUtil.isNull(firstNum)) {
            firstNum = "0";
        }

        if (StringUtil.isNull(lastChar)) {
            lastChar = "a";
        }
        try {
            sign = firstNum + sign_temp.substring(1, 2) + sign_temp.substring(3, 4) + sign_temp.substring(15, 16) + lastChar + sign_temp.substring(31, 32);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sign == null) {
            return "";
        }
        return sign;
    }

    // 得到本地    当前版本名称
    public static String getCurrentVersionName(Context context) {

        String versionName = "2.8.3";
        if (context == null) {
            return versionName;
        }
        try {
            versionName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;

        } catch (PackageManager.NameNotFoundException e) {

            e.printStackTrace();
        }
        return versionName;
    }


}
