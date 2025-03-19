package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.api.model.AlarmInfo;
import cn.epimore.gmv.service.service.api.EventApi;
import cn.epimore.gmv.service.service.api.SseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventApiImpl implements EventApi {
    @Autowired
    private SseApi sseApi;

    //todo 数据持久化
    @Override
    public void handleAlarmEvent(String uid, AlarmInfo info) {
        sseApi.sendDeviceMsg(uid, info);
    }
}
