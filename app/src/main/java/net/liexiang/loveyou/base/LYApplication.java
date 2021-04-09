package net.liexiang.loveyou.base;

import net.liexiang.loveyou.network.HttpConfig;
import net.liexiang.loveyou.network.InterceptorHeader;
import net.liexiang.loveyou.network.WebUrl;

/**
 * @Author sbqfile
 * @Date 2020-01-29 12:25
 * @Description
 **/
public class LYApplication extends BaseApplication {

    private static LYApplication instance;

    public static LYApplication get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //初始化网络模块
        HttpConfig httpConfig = new HttpConfig();
        httpConfig.addInterceptor(InterceptorHeader.get());
        httpConfig.setBaseUrl(WebUrl.HTTP_DEV);
        httpConfig.setConnectTimeOut(120);
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        httpConfig.addInterceptor(httpLoggingInterceptor);
//        httpConfig.addInterceptor(HeaderAgentInterceptor.get(AppConfig.CLIENT_NAME));
//        httpConfig.addInterceptor(new DynamicTimeoutInterceptor());
        httpConfig.init();



    }
}
