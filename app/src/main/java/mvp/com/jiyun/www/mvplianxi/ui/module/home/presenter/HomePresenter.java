package mvp.com.jiyun.www.mvplianxi.ui.module.home.presenter;

import mvp.com.jiyun.www.mvplianxi.modle.biz.IModle;
import mvp.com.jiyun.www.mvplianxi.modle.biz.IModleImpl;
import mvp.com.jiyun.www.mvplianxi.modle.callback.NetworkCallback;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.ui.module.home.contract.HomeContract;

public class HomePresenter implements HomeContract.Presenter {
    private IModle mModle;
    private HomeContract.View mView;

    public HomePresenter() {
        this.mModle = new IModleImpl();
    }

    @Override
    public void getNewsList() {
        mModle.newList(new NetworkCallback<StudentBean>() {
            /*
            * TODO 成功方法
            * */
            @Override
            public void onSuccess(StudentBean bean) {
                if (mView != null) {
                    mView.showNewList(bean);
                }
            }
            /*
             * TODO 失败方法
             * */
            @Override
            public void onError(String errorMsg) {
                mView.showMsg(errorMsg);
            }
        });
    }

    @Override
    public void attach(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void decath() {
        this.mView = null;
    }
}
