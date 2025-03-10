package cn.epimore.gmv.service.web;

import cn.epimore.gmv.api.common.Result;
import cn.epimore.gmv.api.model.*;
import cn.epimore.gmv.service.service.api.DcOptApi;
import com.alibaba.fastjson2.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/opt")
@Api(value = "/stream", tags = "媒体流信息：无需关闭流,流未被使用时会自动关闭")
@Validated
public class DcOptController {
    private final static Logger logger = LoggerFactory.getLogger(DcOptController.class);
    @Resource
    private DcOptApi dcOptApi;

    @PostMapping("/play/live")
    @ApiOperation(value = "/play/live", notes = "获取实时直播地址失败")
    public ResponseEntity<StreamUri> getPlayLiveUri(@RequestBody @NotNull IdMap idMap) {
        logger.info("getPlayLiveUri:{}", JSON.toJSONString(idMap));
        try {
            StreamUri streamUri = dcOptApi.getPlayLiveUri(idMap);
            return Result.success(streamUri);
        } catch (Exception e) {
            logger.error("getPlayLiveUri异常", e);
            return Result.failure("获取实时直播地址失败.");
        }
    }

    @PostMapping("/play/back")
    @ApiOperation(value = "/play/back", notes = "获取历史回放地址失败")
    public ResponseEntity<StreamUri> getPlayBackUri(@RequestBody @NotNull PlayBackReq backReq) {
        logger.info("getPlayBackUri:{}", JSON.toJSONString(backReq));
        try {
//            StreamUri streamUri = new StreamUri("streamId", "https://v-ngb.qf.56.com/live/3434287_1741004753492.flv", null);

            StreamUri streamUri = dcOptApi.getPlayBackUri(backReq);
            return Result.success(streamUri);
        } catch (Exception e) {
            logger.error("getPlayBackUri", e);
            return Result.failure("获取历史回放地址失败.");
        }
    }

    @PostMapping("/play/back/seek")
    @ApiOperation(value = "/play/back/seek", notes = "操作历史监控拖动播放")
    public ResponseEntity<Boolean> cmdPlayBackSeek(@RequestBody @NotNull PlaySeekModel model) {
        logger.info("cmdPlayBackSeek:{}", JSON.toJSONString(model));
        try {
            boolean b = dcOptApi.cmdPlayBackSeek(model);
            return Result.success(b);
        } catch (Exception e) {
            logger.error("cmdPlayBackSeek", e);
            return Result.failure("操作历史监控拖动播放失败.");
        }
    }

    @PostMapping("/play/back/speed")
    @ApiOperation(value = "/play/back/speed", notes = "操作历史监控倍速播放")
    public ResponseEntity<Boolean> cmdPlayBackSpeed(@RequestBody @NotNull PlaySpeedModel model) {
        logger.info("cmdPlayBackSpeed:{}", JSON.toJSONString(model));
        try {
            boolean b = dcOptApi.cmdPlayBackSpeed(model);
            return Result.success(b);
        } catch (Exception e) {
            logger.error("cmdPlayBackSpeed", e);
            return Result.failure("操作历史监控倍速播放失败.");
        }
    }

    @PostMapping("/control/ptz")
    @ApiOperation(value = "/control/ptz", notes = "云台控制")
    public ResponseEntity<Boolean> cmdControlPtz(@RequestBody @NotNull PtzControlModel model) {
        logger.info("cmdControlPtz:{}", JSON.toJSONString(model));
        try {
            boolean b = dcOptApi.cmdControlPtz(model);
            return Result.success(b);
        } catch (Exception e) {
            logger.error("cmdControlPtz", e);
            return Result.failure("云台控制失败.");
        }
    }
}
