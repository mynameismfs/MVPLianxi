package mvp.com.jiyun.www.mvplianxi.modle.http;

public class HttpFactory {
    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
    public static IHttp retrofitcreate(){
        return (IHttp) RetrofitUtils.getInstence();
    }
}
