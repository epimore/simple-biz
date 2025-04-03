package cn.epimore.gmv.service.mapper;

import cn.epimore.gmv.api.model.GmvDeviceChannel;
import cn.epimore.gmv.api.model.GmvDeviceInfo;
import cn.epimore.gmv.api.model.ImageInfo;
import cn.epimore.gmv.api.model.ImageQuery;

import java.util.List;

public interface DeviceInfoMapper {

    List<GmvDeviceInfo> getGmvDeviceInfoList(GmvDeviceInfo info);

    List<GmvDeviceChannel> getGmvDeviceChannelList(String deviceId);

    List<ImageInfo> getImageInfo(ImageQuery query);
}
