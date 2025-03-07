package cn.epimore.gmv.service.cfg;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "gmv.api")
public class GmvApiConfig {
    private String host;
    private String playLive;
    private String playBack;
    private String playBackSeek;
    private String playBackSpeed;
    private String save;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPlayLive() {
        return playLive;
    }

    public void setPlayLive(String playLive) {
        this.playLive = playLive;
    }

    public String getPlayBack() {
        return playBack;
    }

    public void setPlayBack(String playBack) {
        this.playBack = playBack;
    }

    public String getPlayBackSeek() {
        return playBackSeek;
    }

    public void setPlayBackSeek(String playBackSeek) {
        this.playBackSeek = playBackSeek;
    }

    public String getPlayBackSpeed() {
        return playBackSpeed;
    }

    public void setPlayBackSpeed(String playBackSpeed) {
        this.playBackSpeed = playBackSpeed;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }
}
