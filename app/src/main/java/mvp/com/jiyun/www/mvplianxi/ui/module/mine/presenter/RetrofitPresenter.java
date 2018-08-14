package mvp.com.jiyun.www.mvplianxi.ui.module.mine.presenter;

import mvp.com.jiyun.www.mvplianxi.modle.biz.IModle;
import mvp.com.jiyun.www.mvplianxi.modle.biz.IModleImpl;
import mvp.com.jiyun.www.mvplianxi.modle.callback.NetworkCallback;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.ui.module.mine.contract.RetrofitContract;

public class RetrofitPresenter implements RetrofitContract.Presenter {
    private IModle mModle;
    private RetrofitContract.View mView;

    public RetrofitPresenter() {
        this.mModle = new IModleImpl();
    }

    @Override
    public void getShoww() {
        mModle.gggggggggg(new NetworkCallback<StudentBean>() {
            @Override
            public void onSuccess(StudentBean studentBean) {
                mView.show(studentBean);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void attach(RetrofitContract.View view) {
        this.mView = view;
    }

    @Override
    public void decath() {
        this.mView = null;
    }
}
