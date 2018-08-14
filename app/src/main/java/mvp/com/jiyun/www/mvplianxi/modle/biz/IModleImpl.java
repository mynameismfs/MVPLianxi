package mvp.com.jiyun.www.mvplianxi.modle.biz;

import mvp.com.jiyun.www.mvplianxi.config.Urls;
import mvp.com.jiyun.www.mvplianxi.modle.callback.NetworkCallback;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.modle.http.HttpFactory;
import mvp.com.jiyun.www.mvplianxi.modle.http.RetrofitUtils;
import retrofit2.Retrofit;
import retrofit2.http.Url;

public class IModleImpl implements IModle{

    @Override
    public void newList(NetworkCallback<StudentBean> callback) {
        HttpFactory.create().doGet(Urls.NEWSLIST,callback);
    }

    @Override
    public void newafdfasd(NetworkCallback<StudentBean> callback) {
        HttpFactory.create().doGet(Urls.NEWSLIST,callback);
    }

    @Override
    public void gggggggggg(NetworkCallback<StudentBean> callback) {
       HttpFactory.retrofitcreate().doGet(Urls.NEWSLIST,callback);
    }
}
