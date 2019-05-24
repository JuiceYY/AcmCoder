package cn.istary.acmcoder.data.response;

import java.util.List;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:05
 */

public class GameResponse extends BaseResponse {

    private List<Game> data;

    public List<Game> getData() {
        return data;
    }

    public void setData(List<Game> data) {
        this.data = data;
    }


}
