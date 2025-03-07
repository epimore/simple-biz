package cn.epimore.gmv.service.web;

import cn.epimore.gmv.api.common.Result;
import cn.epimore.gmv.api.model.GmvDeviceChannel;
import cn.epimore.gmv.api.model.GmvDeviceInfo;
import cn.epimore.gmv.api.model.IdMap;
import cn.epimore.gmv.service.service.api.DeviceInfoApi;
import com.alibaba.fastjson2.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/info")
@Api(value = "/info", tags = "设备信息")
@Validated
public class DeviceInfoController {
    private final static Logger logger = LoggerFactory.getLogger(DeviceInfoController.class);
    private final DeviceInfoApi deviceInfoApi;

    @Autowired
    public DeviceInfoController(DeviceInfoApi deviceInfoApi) {
        this.deviceInfoApi = deviceInfoApi;
    }

    @PostMapping("/devices")
    @ApiOperation(value = "devices", notes = "查询设备列表")
    public ResponseEntity<List<GmvDeviceInfo>> getGmvDeviceInfoList(@RequestBody @NotNull GmvDeviceInfo info) {
        logger.info("getGmvDeviceInfoList;{}", JSON.toJSONString(info));
        try {
            List<GmvDeviceInfo> list = deviceInfoApi.getGmvDeviceInfoList(info);
            return Result.success(list);
        } catch (Exception e) {
            logger.error("getGmvDeviceInfoList异常", e);
            return Result.failure("查询设备列表失败.");
        }
    }

    @PostMapping("/channels")
    @ApiOperation(value = "channels", notes = "查询相机通道列表")
    public ResponseEntity<List<GmvDeviceChannel>> getGmvDeviceChannelList(@RequestBody @NotNull IdMap idMap) {
        logger.info("getGmvDeviceChannelList,查询相机通道列表;{}", JSON.toJSONString(idMap));
        try {
            List<GmvDeviceChannel> list = deviceInfoApi.getGmvDeviceChannelList(idMap.getDeviceId());
            return Result.success(list);
        } catch (Exception e) {
            logger.error("getGmvDeviceChannelList异常", e);
            return Result.failure("查询相机通道列表失败.");
        }
    }


}
