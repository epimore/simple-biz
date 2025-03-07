package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.service.mapper.GmvDeviceMapper;
import cn.epimore.gmv.service.service.api.GmvDeviceApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GmvDeviceApiImpl implements GmvDeviceApi {
    @Resource
    private GmvDeviceMapper gmvDeviceMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return gmvDeviceMapper.deleteByPrimaryKey(id);
    }
}
