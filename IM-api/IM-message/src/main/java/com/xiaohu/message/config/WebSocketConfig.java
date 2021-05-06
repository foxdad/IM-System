package com.xiaohu.message.config;

import com.xiaohu.message.config.Interceptor.WebSocketInterceptor;
import com.xiaohu.message.handle.MessageHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/4/14 10:36
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler(),"/xiaohu/ws/{uid}").setAllowedOrigins("*").addInterceptors(webSocketInterceptor);
    }

    @Bean
    public WebSocketHandler webSocketHandler(){
        return new MessageHandle();
//        return new TextMessageHandle();
    }
}
