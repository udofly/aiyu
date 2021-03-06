package net.liexiang.loveyou.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import net.liexiang.loveyou.base.LYApplication;
import net.liexiang.loveyou.utils.StringUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Describe: 为所有请求统一添加header
 * Created by Gao Chunfa on 4/9/21.
 * Company: Hainan DaDi(Jinan) Network Technology Co. Ltd
 */
public class InterceptorHeader implements Interceptor {

    public static Context mContext;

    private static InterceptorHeader instance;

    public static InterceptorHeader get(Context context) {
        mContext = context;
        if (instance == null) {
            instance = new InterceptorHeader();
        }
        return instance;
    }

    private String newToken;

    public void reset() {
        newToken = "";
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request         request = chain.request();
        Request.Builder builder = request.newBuilder();


        //添加请求token
//        if (TextUtils.isEmpty(newToken)) {
//            newToken = "Bearer " + "token";
//        }
//        builder.addHeader("Authorization", "Bearer " + LYApplication.token);
//        builder.addHeader("X-APP-VERSION", StringUtil.test(mContext));

        Response proceed = chain.proceed(builder.build());
        if (proceed.code() == 403) {
            //todo
//            TeacherAccountHolder.getInstance().loginOut();
//            ActivityUtils.finishAllActivities();
//            ActivityUtils.startLauncherActivity();
        }
        String responseAuthorization = proceed.header("Authorization");
        if (!TextUtils.isEmpty(responseAuthorization)) {
            newToken = responseAuthorization;
        }
        return proceed;
    }


}
