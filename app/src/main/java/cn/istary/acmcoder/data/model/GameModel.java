package cn.istary.acmcoder.data.model;

import android.util.Log;

import cn.istary.acmcoder.base.BaseObserver;
import cn.istary.acmcoder.base.Constant;
import cn.istary.acmcoder.data.api.GameApi;
import cn.istary.acmcoder.data.response.GameResponse;
import cn.istary.acmcoder.presenter.listener.HandleGameListener;
import cn.istary.acmcoder.util.http.RetrofitHelper;
import cn.istary.acmcoder.util.http.ThreadChanger;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:38
 */

public class GameModel {

    private static final String TAG = "GameModel";

    public void queryGame(final HandleGameListener listener){
        RetrofitHelper.getInstance()
                .createApi(GameApi.class, Constant.DOMAIN)
                .getGame()
                .compose(ThreadChanger.<GameResponse>io2main())
                .subscribe(new BaseObserver<GameResponse>() {
                    @Override
                    public void onNext(GameResponse gameResponse) {
                        Log.d(TAG, gameResponse+"");
                        listener.onSuccess(gameResponse);
                    }

                    @Override
                    protected void onNetError(Throwable e) {
                        listener.onFailed("网络错误" + e.getMessage());
                    }
                });
    }

}
