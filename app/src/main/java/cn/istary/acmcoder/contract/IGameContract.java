package cn.istary.acmcoder.contract;

import java.util.List;

import cn.istary.acmcoder.data.response.Game;
import cn.istary.acmcoder.presenter.listener.HandleGameListener;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:31
 */

public interface IGameContract {

    interface IView{

        void showProcessDialog();

        void closeProcessDialog();

        void setPresenter(IPresenter presenter);

        void showGame(List<Game> gameList);

        void showError(String errorMsg);
    }

    interface IPresenter{

        void queryGame();

        void openDetail(int id, String url);
    }

}
