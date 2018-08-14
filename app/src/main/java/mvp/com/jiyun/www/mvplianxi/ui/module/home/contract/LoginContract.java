package mvp.com.jiyun.www.mvplianxi.ui.module.home.contract;


import mvp.com.jiyun.www.mvplianxi.base.BasePresenter;
import mvp.com.jiyun.www.mvplianxi.base.BaseView;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;

public interface LoginContract {
    interface View extends BaseView {
        /*
         *TODO  记住
         * 只要页面发生了变化 每一个变化都得对应一个变化的方法
         */
        void showNewList(StudentBean bean);
        void showMsg(String msg);
        void toDetailView();
//        void loadMore();
//        void refersh();
//        void showLoadingProgress();
//        void dimiss();
//        void showDialog();
//        void netWorkError();
    }
    interface Presenter extends BasePresenter<View> {
        void getNewsList();
    }

}
