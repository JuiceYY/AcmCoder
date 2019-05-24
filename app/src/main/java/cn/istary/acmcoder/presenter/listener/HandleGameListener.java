package cn.istary.acmcoder.presenter.listener;

import java.util.List;

import cn.istary.acmcoder.data.response.Game;
import cn.istary.acmcoder.data.response.GameResponse;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:32
 */

public interface HandleGameListener {

    void onSuccess(GameResponse response);

    void onFailed(String errorMsg);

}
