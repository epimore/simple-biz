package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.api.common.GmvSessionResult;
import cn.epimore.gmv.api.model.*;
import cn.epimore.gmv.service.cfg.GmvApiConfig;
import cn.epimore.gmv.service.service.api.StreamApi;
import cn.epimore.gmv.service.utils.GmvHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class StreamApiImpl implements StreamApi {

    private final GmvApiConfig gmvApiConfig;

    @Autowired
    public StreamApiImpl(GmvApiConfig gmvApiConfig) {
        this.gmvApiConfig = gmvApiConfig;
    }

    @Override
    public StreamUri getPlayLiveUri(IdMap idMap) {
        String url = String.format("%s%s", gmvApiConfig.getHost(), gmvApiConfig.getPlayLive());
        Map<String, String> map = new HashMap<>();
        map.put("device_id", idMap.getDeviceId());
        map.put("channel_id", idMap.getChannelId());
        GmvSessionResult<StreamUri> result = GmvHttpUtil.post(url, map, StreamUri.class);
        if (result == null) {
            throw new RuntimeException("获取实时直播地址失败");
        }
        if (result.getCode() != 200) {
            throw new RuntimeException(result.getMsg());
        }
        return result.getData();
    }

    @Override
    public StreamUri getPlayBackUri(PlayBackReq backReq) {
        String url = String.format("%s%s", gmvApiConfig.getHost(), gmvApiConfig.getPlayBack());
        Map<String, Object> map = new HashMap<>();
        map.put("device_id", backReq.getDeviceId());
        map.put("channel_id", backReq.getChannelId());
        ZoneId zoneId = ZoneId.systemDefault();
        Long st = backReq.getSt().atZone(zoneId).toInstant().getEpochSecond();
        Long et = backReq.getEt().atZone(zoneId).toInstant().getEpochSecond();
        map.put("st", st);
        map.put("et", et);
        GmvSessionResult<StreamUri> result = GmvHttpUtil.post(url, map, StreamUri.class);
        if (result == null) {
            throw new RuntimeException("获取历史回放地址失败");
        }
        if (result.getCode() != 200) {
            throw new RuntimeException(result.getMsg());
        }
        return result.getData();
    }

    @Override
    public boolean cmdPlayBackSeek(PlaySeekModel seekModel) {
        String url = String.format("%s%s", gmvApiConfig.getHost(), gmvApiConfig.getPlayBackSeek());
        Map<String, Object> map = new HashMap<>();
        map.put("streamId", seekModel.getStreamId());
        map.put("seekSecond", seekModel.getSeekSecond());
        GmvSessionResult<Boolean> result = GmvHttpUtil.post(url, map, Boolean.class);
        if (result == null) {
            throw new RuntimeException("拖动操作失败");
        }
        if (result.getCode() != 200) {
            throw new RuntimeException(result.getMsg());
        }
        return result.getData();
    }

    @Override
    public boolean cmdPlayBackSpeed(PlaySpeedModel speedModel) {
        String url = String.format("%s%s", gmvApiConfig.getHost(), gmvApiConfig.getPlayBackSpeed());
        Map<String, Object> map = new HashMap<>();
        map.put("streamId", speedModel.getStreamId());
        map.put("speedRate", speedModel.getSpeedRate());
        GmvSessionResult<Boolean> result = GmvHttpUtil.post(url, map, Boolean.class);
        if (result == null) {
            throw new RuntimeException("倍速操作失败");
        }
        if (result.getCode() != 200) {
            throw new RuntimeException(result.getMsg());
        }
        return result.getData();
    }


}
