package net.liexiang.loveyou.network;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author sbqfile
 * @Date 2020-01-29 22:14
 * @Description 网络请求的配置
 **/
public class HttpConfig {

    private int               connectTimeOut = 60;
    private String            baseUrl        = "";
    private List<Interceptor> interceptors   = new ArrayList<>();

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(connectTimeOut, TimeUnit.SECONDS);

        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }

        singleInstance = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(builder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static Retrofit singleInstance;

    public static Retrofit getRetrofit() {
        return singleInstance;
    }

}
