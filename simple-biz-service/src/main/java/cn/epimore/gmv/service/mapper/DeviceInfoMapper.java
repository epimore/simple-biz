package cn.epimore.gmv.service.mapper;

import cn.epimore.gmv.api.model.*;

import java.util.List;

public interface DeviceInfoMapper {

    List<GmvDeviceInfo> getGmvDeviceInfoList(GmvDeviceInfo info);

    List<GmvDeviceChannel> getGmvDeviceChannelList(String deviceId);

    List<ImageInfo> getImageInfo(ImageQuery query);

    List<RecordVideoInfo> getRecordVideoInfos(IdMap idMap);

    int getRecordingCount(PlayBackReq req);

    String getFilePath(Long fileId);
}
