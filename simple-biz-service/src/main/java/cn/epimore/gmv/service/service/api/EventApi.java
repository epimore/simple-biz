package cn.epimore.gmv.service.service.api;

import cn.epimore.gmv.api.model.AlarmInfo;

public interface EventApi {
    public void handleAlarmEvent(String uid, AlarmInfo info);
}
