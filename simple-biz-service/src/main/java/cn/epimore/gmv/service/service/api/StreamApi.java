package cn.epimore.gmv.service.service.api;

import cn.epimore.gmv.api.model.*;

public interface StreamApi {

    //获取点播流地址
    StreamUri getPlayLiveUri(IdMap idMap);

    //获取历史回放点播流地址
    StreamUri getPlayBackUri(PlayBackReq backReq);

    //操作历史监控拖动播放
    boolean cmdPlayBackSeek(PlaySeekModel seekModel);

    //操作历史监控倍速播放
    boolean cmdPlayBackSpeed(PlaySpeedModel speedModel);
}
