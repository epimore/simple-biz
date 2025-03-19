package cn.epimore.gmv.service.service.api;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;

public interface SseApi {
    public SseEmitter connect(String uid);

    public void close(String uid);

    public void sendMsg(String uid, Object msg);
    public void sendDeviceMsg(String uid, Object msg);
    public void sendNotifyMsg(String uid, Object msg);
}
