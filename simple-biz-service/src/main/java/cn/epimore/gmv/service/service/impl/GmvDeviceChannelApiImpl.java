package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.api.model.IdMap;
import cn.epimore.gmv.service.mapper.GmvDeviceChannelMapper;
import cn.epimore.gmv.service.service.api.GmvDeviceChannelApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GmvDeviceChannelApiImpl implements GmvDeviceChannelApi {
@Resource
private GmvDeviceChannelMapper channelMapper;

    @Override
    public int deleteByPrimaryKey(IdMap idMap) {
        return channelMapper.deleteByPrimaryKey(idMap);
    }
}
