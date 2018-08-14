package mvp.com.jiyun.www.mvplianxi.ui.module.home.presenter;


import mvp.com.jiyun.www.mvplianxi.modle.biz.IModle;
import mvp.com.jiyun.www.mvplianxi.modle.biz.IModleImpl;
import mvp.com.jiyun.www.mvplianxi.modle.callback.NetworkCallback;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.ui.module.home.contract.LoginContract;

public class LoginPresenter implements LoginContract.Presenter{
    private IModle mModle;
    private LoginContract.View mView;
    public LoginPresenter() {
        this.mModle = new IModleImpl();
    }

    @Override
    public void getNewsList() {
        mModle.newafdfasd(new NetworkCallback<StudentBean>() {
            @Override
            public void onSuccess(StudentBean bean) {
                if (mView!=null)
                mView.showNewList(bean);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void attach(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void decath() {
        this.mView = null;
    }
}
