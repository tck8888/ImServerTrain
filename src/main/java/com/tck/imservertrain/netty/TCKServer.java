package com.tck.imservertrain.netty;


import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * description:</br>
 * created on: 2019/8/30 9:53</br>
 *
 * @author tck
 * @version 1.0
 */

@Component
public class TCKServer {

    private static class SingletonTCKServer {
        static final TCKServer instance = new TCKServer();
    }

    public static TCKServer getInstance() {
        return SingletonTCKServer.instance;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    public TCKServer() {
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new TCKServerInitializer());
    }

    public void start() {
        this.future = server.bind(8088);
        System.err.println("netty websocket server 启动完毕...");
    }
}

