package net.liexiang.loveyou.base;

import net.liexiang.loveyou.network.HttpConfig;
import net.liexiang.loveyou.network.InterceptorHeader;
import net.liexiang.loveyou.network.WebUrl;

/**
 * Describe:
 * Created by Gao Chunfa on 4/16/21.
 * Company: Hainan DaDi(Jinan) Network Technology Co. Ltd
 */
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
        initRetrofit();


    }

    /**
     * 初始化网络模块
     */
    private void initRetrofit() {
//           String url = "http://t.dailian.iliexiang.com/";
        HttpConfig httpConfig = new HttpConfig();
        httpConfig.addInterceptor(InterceptorHeader.get(getApplicationContext()));
        httpConfig.setBaseUrl(WebUrl.HTTP_T);
        httpConfig.setConnectTimeOut(120);
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        httpConfig.addInterceptor(httpLoggingInterceptor);
//        httpConfig.addInterceptor(HeaderAgentInterceptor.get(AppConfig.CLIENT_NAME));
//        httpConfig.addInterceptor(new DynamicTimeoutInterceptor());
        httpConfig.init();
    }
}
