package cn.epimore.gmv.service.service.api;

import cn.epimore.gmv.api.model.GmvDeviceChannel;
import cn.epimore.gmv.api.model.GmvDeviceInfo;
import cn.epimore.gmv.api.model.ImageInfo;
import cn.epimore.gmv.api.model.ImageQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DeviceInfoApi {
    List<GmvDeviceInfo> getGmvDeviceInfoList(GmvDeviceInfo info);
    List<GmvDeviceChannel> getGmvDeviceChannelList(String deviceId);
    PageInfo<ImageInfo> getImageInfo(ImageQuery query);
}
