package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.api.model.GmvDeviceChannel;
import cn.epimore.gmv.api.model.GmvDeviceInfo;
import cn.epimore.gmv.service.mapper.DeviceInfoMapper;
import cn.epimore.gmv.service.service.api.DeviceInfoApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceInfoApiImpl implements DeviceInfoApi {
    @Resource
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public List<GmvDeviceInfo> getGmvDeviceInfoList(GmvDeviceInfo info) {
        return deviceInfoMapper.getGmvDeviceInfoList(info);
    }

    @Override
    public List<GmvDeviceChannel> getGmvDeviceChannelList(String deviceId) {
        return deviceInfoMapper.getGmvDeviceChannelList(deviceId);
    }
}
