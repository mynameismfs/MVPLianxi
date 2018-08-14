package mvp.com.jiyun.www.mvplianxi.ui.module.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mvp.com.jiyun.www.mvplianxi.R;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import mvp.com.jiyun.www.mvplianxi.ui.module.home.contract.LoginContract;
import mvp.com.jiyun.www.mvplianxi.ui.module.home.presenter.LoginPresenter;
import mvp.com.jiyun.www.mvplianxi.ui.module.mine.activity.Main3Activity;

public class Main2Activity extends AppCompatActivity implements LoginContract.View{


    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Main2Activity.this, Main3Activity.class));
    }
});
        presenter = new LoginPresenter();
        presenter.attach(this);
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
}
