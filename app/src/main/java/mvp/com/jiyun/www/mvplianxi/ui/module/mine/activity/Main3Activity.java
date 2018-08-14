package mvp.com.jiyun.www.mvplianxi.ui.module.mine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mvp.com.jiyun.www.mvplianxi.R;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.ui.module.mine.contract.RetrofitContract;
import mvp.com.jiyun.www.mvplianxi.ui.module.mine.presenter.RetrofitPresenter;

public class Main3Activity extends AppCompatActivity implements RetrofitContract.View{


    private RetrofitContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        presenter = new RetrofitPresenter();
        presenter.getShoww();
    }


    @Override
    public void show(StudentBean studentBean) {
        Toast.makeText(this, studentBean.getResult().getData().get(0).getAuthor_name(), Toast.LENGTH_SHORT).show();
    }
}
