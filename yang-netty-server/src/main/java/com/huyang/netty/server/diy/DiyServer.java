package com.huyang.netty.server.diy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiyServer {

    private int port;

    public DiyServer(int port){
        this.port=port;
    }

    public void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        ChannelFuture channelFuture= null;
        try {
            channelFuture = serverBootstrap.group(group).channel(NioServerSocketChannel.class).childHandler(new DIyServerInboundHandler()).bind(this.port).sync();
            System.out.println("DIY server successfully at port:"+this.port);
        } catch (InterruptedException e) {
            group.shutdownGracefully();
            e.printStackTrace();
        }
        channelFuture.awaitUninterruptibly();
    }




}
