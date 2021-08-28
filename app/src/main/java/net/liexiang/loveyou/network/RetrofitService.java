package net.liexiang.loveyou.network;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @Author sbqfile
 * @Date 2020-01-29 19:51
 * @Description
 **/
public interface RetrofitService {

//    @POST("api/dailian/home/hall")
    @POST("api/dailian/system_info")
    Observable<String> getSystemInfo(@Body RequestBody bodyF);
//    @POST("api/dailian/home/hall")
    @POST("api/dailian/system_info")
    Observable<String> getSystemInfo2(@QueryMap Map<String, Object> parameters);

//      @POST("api_v2/user/profile/detail")
      @POST("api_v1/site/android/version")
    Call<String> getUserInfo(@Body RequestBody bodyF);
//QueryMap
    /**
     * @GET("query")
     * Call<Book> getSearchBook(@QueryMap Map<String, String> parameters);
     */
    @GET("query")
    Call<String> getSearchBook(@QueryMap Map<String, Object> parameters);


    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<String> getCall();

}
