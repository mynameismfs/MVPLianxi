package mvp.com.jiyun.www.mvplianxi.modle.callback;

public interface NetworkCallback<T> {
    /*
    * 成功方法
    * */
    void onSuccess(T t);
    /*
    * 失败方法
    * */
    void onError(String errorMsg);
}
