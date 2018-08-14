package mvp.com.jiyun.www.mvplianxi.modle.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import mvp.com.jiyun.www.mvplianxi.config.Keys;
import mvp.com.jiyun.www.mvplianxi.config.Urls;
import mvp.com.jiyun.www.mvplianxi.modle.biz.RetrofitService;
import mvp.com.jiyun.www.mvplianxi.utils.EnhancedCacheInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static RetrofitService getRetrofitService(){
        return new Retrofit.Builder().build().create(RetrofitService.class);
    }
private static volatile RetrofitUtils retorfitUtils;

    public static RetrofitUtils getInstence() {
        if (null == retorfitUtils) {
            synchronized (RetrofitUtils.class) {
                if (null == retorfitUtils) {
                    retorfitUtils = new RetrofitUtils();
                }
            }
        }
        return retorfitUtils;
    }

    private RetrofitUtils() {
    }

    //高级缓存支持POST
    private Retrofit getRetrofits(String baseurl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new EnhancedCacheInterceptor())//高级缓存拦截器
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request().newBuilder()
                                //加入自己的请求头，
//                                .addHeader("apptoken", String.valueOf(SPUtil.getInstance().get(Keys.APPTOKEN, "")))
//                                .addHeader("user-agent", String.valueOf(SPUtil.getInstance().get(Keys.USER_AGENT, "")))
//                                .addHeader("Authorization", "")
//                                .addHeader("did", String.valueOf(SPUtil.getInstance().get(Keys.SOLENAME, "")))
//                                .addHeader("cid", "dd2a152f6d132980462385b10b8487bb")
//                                .addHeader("userId", String.valueOf(SPUtil.getInstance().get(Keys.ID, 0)))
//                                .addHeader("oCode", "350010")
//                                .addHeader("appType", "univstarUnion")
                                .build();


                        return chain.proceed(request);
                    }
                });


        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }



    //获取Retrofit
    private Retrofit getRetrofit() {
        return getRetrofits(Urls.NEWSLIST);
    }


    //获取Service
    public RetrofitService getLoginService() {
        return getRetrofit().create(RetrofitService.class);
    }

    /**
     * 检查网络是否可用
     *
     * @param context
     * @return
     */

    public static boolean isNetworkAvailable(Context context) {
//判断是否有网络

        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

}
