package cn.istary.acmcoder.data.response;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:08
 */

public class Game {

    private String title;
    private String platformName;
    private long startTime;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

}
