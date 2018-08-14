package mvp.com.jiyun.www.mvplianxi.ui.module.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mvp.com.jiyun.www.mvplianxi.R;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.ui.module.home.contract.HomeContract;
import mvp.com.jiyun.www.mvplianxi.ui.module.home.presenter.HomePresenter;

public class MainActivity extends AppCompatActivity implements HomeContract.View {
    HomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new HomePresenter();
        presenter.attach(this);
        findViewById(R.id.mbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        /*
         * TODO 调用p层请求数据
         * */
        presenter.getNewsList();
    }

    @Override
    public void showNewList(StudentBean bean) {
        Toast.makeText(this, bean.getResult().getData().get(0).getAuthor_name(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void toDetailView() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.decath();
    }
}
