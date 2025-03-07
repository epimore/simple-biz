package cn.epimore.gmv.service.web;

import cn.epimore.gmv.api.common.Result;
import cn.epimore.gmv.api.model.IdMap;
import cn.epimore.gmv.service.service.api.GmvDeviceChannelApi;
import com.alibaba.fastjson2.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/channel")
@Api(value = "/channel", tags = "相机信息")
@Validated
public class GmvChannelController {
    private final static Logger logger = LoggerFactory.getLogger(GmvChannelController.class);
    private final GmvDeviceChannelApi channelApi;

    @Autowired
    public GmvChannelController(GmvDeviceChannelApi channelApi) {
        this.channelApi = channelApi;
    }

    @PostMapping("/rm")
    @ApiOperation(value = "rm", notes = "删除设备")
    public ResponseEntity deleteByPrimaryKey(@RequestBody @NotNull IdMap idMap) {
        logger.info("deleteByPrimaryKey:{}", JSON.toJSONString(idMap));
        try {
            int i = channelApi.deleteByPrimaryKey(idMap);
            return Result.build(i > 0);
        } catch (Exception e) {
            logger.error("deleteByPrimaryKey异常", e);
            return Result.failure("删除失败");
        }
    }

}
