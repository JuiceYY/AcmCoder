package cn.istary.acmcoder.data.api;

import cn.istary.acmcoder.data.response.GameResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:43
 */

public interface GameApi {

    @GET("/game/all")
    Observable<GameResponse> getGame();

}
