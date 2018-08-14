package mvp.com.jiyun.www.mvplianxi.app;

import android.app.Application;

import mvp.com.jiyun.www.mvplianxi.utils.SUtils;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SUtils.initialize(this);
    }
}
