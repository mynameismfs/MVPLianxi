package mvp.com.jiyun.www.mvplianxi.ui.module.mine.contract;

import mvp.com.jiyun.www.mvplianxi.base.BasePresenter;
import mvp.com.jiyun.www.mvplianxi.base.BaseView;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;

public interface RetrofitContract {
    interface View extends BaseView{
        void show(StudentBean studentBean);
    }
    interface Presenter extends BasePresenter<View>{
         void getShoww();
    }
}
