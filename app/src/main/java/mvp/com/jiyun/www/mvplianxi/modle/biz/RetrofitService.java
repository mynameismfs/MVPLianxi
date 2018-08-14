package mvp.com.jiyun.www.mvplianxi.modle.biz;

import io.reactivex.Observable;
import mvp.com.jiyun.www.mvplianxi.modle.entity.StudentBean;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitService {
    //Model的业务方法
    @GET
    Observable<StudentBean> userInfo();
}
