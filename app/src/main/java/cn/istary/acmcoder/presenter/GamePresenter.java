package cn.istary.acmcoder.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import cn.istary.acmcoder.contract.IGameContract;
import cn.istary.acmcoder.data.model.GameModel;
import cn.istary.acmcoder.data.response.GameResponse;
import cn.istary.acmcoder.presenter.listener.HandleGameListener;
import cn.istary.acmcoder.util.MyLog;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:35
 */

public class GamePresenter implements IGameContract.IPresenter {

    private static final String TAG = "GamePresenter";

    private GameModel mGameModel;
    private IGameContract.IView mView;

    public GamePresenter(IGameContract.IView view){
        this.mView = view;
        mGameModel = new GameModel();
    }

    @Override
    public void queryGame() {
        mView.showProcessDialog();
        mGameModel.queryGame(new HandleGameListener() {
            @Override
            public void onSuccess(GameResponse response) {
                mView.closeProcessDialog();
                Log.e(TAG, response+"");
                if(response.getCode() == 0){
                    //服务器返回成功
                    mView.showGame(response.getData());
                }else{
                    mView.showError("error: code = " + response.getCode() + ", msg = " + response.getMsg());
                }
            }

            @Override
            public void onFailed(String errorMsg) {
                mView.closeProcessDialog();
                mView.showError(errorMsg);
            }
        });
    }

    @Override
    public void openDetail(int id, String url) {

    }

}
