package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.api.model.GmvOauth;
import cn.epimore.gmv.service.mapper.GmvOauthMapper;
import cn.epimore.gmv.service.service.api.GmvOauthApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GmvOauthApiImpl implements GmvOauthApi {
    @Resource
    private GmvOauthMapper gmvOauthMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return gmvOauthMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GmvOauth record) {
        record.setCreateTime(LocalDateTime.now());
        return gmvOauthMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(GmvOauth record) {
        return gmvOauthMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<GmvOauth> getGmvOauthList(GmvOauth record) {
        return gmvOauthMapper.getGmvOauthList(record);
    }
}
