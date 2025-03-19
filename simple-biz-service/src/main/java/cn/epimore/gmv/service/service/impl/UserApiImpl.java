package cn.epimore.gmv.service.service.impl;

import cn.epimore.gmv.api.model.UserInfo;
import cn.epimore.gmv.service.cfg.GmvTokenHolder;
import cn.epimore.gmv.service.service.api.UserApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserApiImpl implements UserApi {

    @Override
    public String login(UserInfo userInfo) {
        if (StringUtils.equals(userInfo.getAccount(), "user001") && StringUtils.equals(userInfo.getPwd(), "pwd12345")) {
            return GmvTokenHolder.buildToken(userInfo.getAccount());
        } else {
            return null;
        }
    }
}
