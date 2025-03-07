package cn.epimore.gmv.service.service.api;

import cn.epimore.gmv.api.model.GmvOauth;

import java.util.List;

public interface GmvOauthApi {
    int deleteByPrimaryKey(String id);

    int insert(GmvOauth record);

    int updateByPrimaryKeySelective(GmvOauth record);

    List<GmvOauth> getGmvOauthList(GmvOauth record);
}
