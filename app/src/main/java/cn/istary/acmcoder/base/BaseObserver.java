package cn.istary.acmcoder.base;

import java.net.ConnectException;

import cn.istary.acmcoder.util.MyLog;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:48
 */

public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        MyLog.d("Observer onSubscribe");
    }

    @Override
    public abstract void onNext(T t);

    @Override
    public void onError(Throwable e) {
        if(e instanceof ConnectException){
            onNetError(e);
        }
        MyLog.e("非网络错误, 无法处理" + e.getMessage());
    }

    protected abstract void onNetError(Throwable e);

    @Override
    public void onComplete() {
        MyLog.d("Observer onComplete");
    }
}
