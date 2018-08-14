package mvp.com.jiyun.www.mvplianxi.base;

public interface BasePresenter<V> {
    /*
    *上下文
    * */
    void attach(V view);
    /*
    * 生命周期
    * */
    void decath();

}
