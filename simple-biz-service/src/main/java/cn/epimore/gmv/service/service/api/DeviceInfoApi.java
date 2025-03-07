package cn.epimore.gmv.service.service.api;

import cn.epimore.gmv.api.model.GmvDeviceChannel;
import cn.epimore.gmv.api.model.GmvDeviceInfo;

import java.util.List;

public interface DeviceInfoApi {
    List<GmvDeviceInfo> getGmvDeviceInfoList(GmvDeviceInfo info);
    List<GmvDeviceChannel> getGmvDeviceChannelList(String deviceId);
}
