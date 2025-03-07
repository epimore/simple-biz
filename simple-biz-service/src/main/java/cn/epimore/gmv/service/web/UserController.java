package cn.epimore.gmv.service.web;

import cn.epimore.gmv.api.common.Result;
import cn.epimore.gmv.api.model.UserInfo;
import com.alibaba.fastjson2.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户登录API")
@Validated
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    @ApiOperation(value = "login", notes = "login")
    public ResponseEntity<String> login(@RequestBody @Validated UserInfo userInfo) {
        logger.info("login:{}", JSON.toJSONString(userInfo));
        try {
            if (StringUtils.equals(userInfo.getAccount(), "user001") && StringUtils.equals(userInfo.getPwd(), "pwd12345")) {
                return Result.success("user001-gmv-token");
            } else {
                return Result.common(401, "账号或密码错误", null);
            }
        } catch (Exception e) {
            logger.error("login异常", e);
            return Result.failure("登录失败");
        }

    }
}
