package cn.epimore.gmv.service.mapper;

import cn.epimore.gmv.api.model.GmvDeviceChannel;
import cn.epimore.gmv.api.model.GmvDeviceInfo;

import java.util.List;

public interface DeviceInfoMapper {

    List<GmvDeviceInfo> getGmvDeviceInfoList(GmvDeviceInfo info);

    List<GmvDeviceChannel> getGmvDeviceChannelList(String deviceId);
}
