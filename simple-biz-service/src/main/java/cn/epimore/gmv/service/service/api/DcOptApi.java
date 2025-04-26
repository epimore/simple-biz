package cn.epimore.gmv.service.service.api;

import cn.epimore.gmv.api.model.*;

import java.util.List;

public interface DcOptApi {

    //获取点播流地址
    StreamUri getPlayLiveUri(IdMap idMap);

    //获取历史回放点播流地址
    StreamUri getPlayBackUri(PlayBackReq backReq);
    //操作历史监控拖动播放

    boolean cmdPlayBackSeek(PlaySeekModel seekModel);
    //操作历史监控倍速播放

    boolean cmdPlayBackSpeed(PlaySpeedModel speedModel);
    //操作云台PTZ

    boolean cmdControlPtz(PtzControlModel ptzControlModel);

    //创建下载任务
    boolean createDownloadTask(PlayBackReq backReq);

    //停止下载任务
    boolean tearDownTask(String bizId);

    //查看下载任务
    List<RecordVideoInfo> downTaskInfo(IdMap idMap);

    //删除文件
    boolean rmFile(Long fileId);
}
