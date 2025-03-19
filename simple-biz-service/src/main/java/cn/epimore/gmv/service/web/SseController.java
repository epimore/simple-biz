package cn.epimore.gmv.service.web;

import cn.epimore.gmv.api.common.Result;
import cn.epimore.gmv.service.cfg.GmvTokenHolder;
import cn.epimore.gmv.service.service.api.SseApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sse")
@Api(value = "/sse", tags = "服务端推送API")
public class SseController {
    private final static Logger logger = LoggerFactory.getLogger(SseController.class);
    @Autowired
    private SseApi sseApi;

    @PostMapping(value = "/connect",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    @ApiOperation(value = "connect", notes = "建立连接")
    @CrossOrigin(allowCredentials = "true", origins = "*")
    public SseEmitter connect() {
        try {
            String userName = GmvTokenHolder.getUserName();
            logger.info("消息推送: 用户:{}，请求建立连接", userName);
            return sseApi.connect(userName);
        } catch (Exception e) {
            logger.error("消息推送，连接失败:", e);
            return null;
        }
    }

    @PostMapping(value = "/close")
    @ApiOperation(value = "close", notes = "关闭连接")
    public ResponseEntity<Boolean> close() {
        try {
            String userName = GmvTokenHolder.getUserName();
            logger.info("消息推送: 用户:{}，主动断开连接", userName);
            sseApi.close(userName);
            return Result.success(true);
        } catch (Exception e) {
            logger.error("消息推送，断开连接:", e);
            return Result.failure("关闭连接失败.");
        }
    }
}
