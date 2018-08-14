package mvp.com.jiyun.www.mvplianxi.modle.http;

import android.os.Looper;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import mvp.com.jiyun.www.mvplianxi.modle.callback.NetworkCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils implements IHttp{
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient httpClient;
    private OkHttpUtils(){
        httpClient = new OkHttpClient.Builder().build();
    }

    public static OkHttpUtils getInstance(){
        if (okHttpUtils == null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }
    @Override
    public <T> void doGet(String url, final NetworkCallback<T> callback) {
        Request request = new Request.Builder().url(url).build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                T t = parseData(result, callback);
                Looper.prepare();
                callback.onSuccess(t);
                Looper.loop();

            }
        });
    }

    @Override
    public <T> void doGet(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void doPost(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public void upload(String url, Map<String, File> files, Map<String, String> params, NetworkCallback<String> callback) {

    }

    @Override
    public void download() {

    }

    @Override
    public void loadImage(String url, ImageView view) {

    }
    private <T> T parseData(String jsonData,NetworkCallback<T> callback){

        Type[] interfacesTypes = callback.getClass().getGenericInterfaces();

        Type[] genericType2 = ((ParameterizedType) interfacesTypes[0]).getActualTypeArguments();
        Class<T> classes = (Class<T>) genericType2[0];
        Gson gson = new Gson();
        T t = gson.fromJson(jsonData, classes);
        return t;

    }
}
