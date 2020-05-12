package com.cy.ahoServer.config;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@ServerEndpoint("/im/{userId}")
@Component
public class WebSocketServer {
	

    private static int onlineCount = 0;

    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    
    private Session session;
    
    private String userId="";

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId) {
        this.session = session;
        this.userId=userId;
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            webSocketMap.put(userId,this);
        }else{
            webSocketMap.put(userId,this);
            addOnlineCount(userId);
        }

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
        	e.printStackTrace();
        	System.out.println("用户:"+userId+",网络异常!!!!!!");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            //从set中删除
            subOnlineCount();
        }
        System.out.println("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
    	System.out.println("用户消息:"+userId+",报文:"+message);
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
    	System.out.println("用户错误:"+this.userId+",原因:"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 发送自定义消息
     * */
    public static void sendInfo(String message,@PathParam("userId") String userId) throws IOException {
    	WebSocketServer server=webSocketMap.get(userId);
    	if (server!=null) {
    		server.sendMessage(message);
		}
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount(String userId) {
        WebSocketServer.onlineCount++;
        System.out.println("用户连接:"+userId+",当前在线人数为:" + getOnlineCount());

    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
