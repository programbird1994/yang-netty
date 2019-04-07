package com.huyang.netty.client.diy;

import com.huyang.netty.common.Signal;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class DiyClientChannelHandler extends ChannelInboundHandlerAdapter {
    private String data;

    public DiyClientChannelHandler(String data) {
        this.data = data;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer(data, CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf received = (ByteBuf) msg;
        if (received.equals(Signal.disconnect_server_signal)) {
            System.out.println("server already received my disconnect request, will disconnect now");
            ctx.channel().disconnect();
        } else {
            System.out.println("client received :"+received.toString(CharsetUtil.UTF_8));
            Scanner scanner=new Scanner(System.in);
            System.out.println("please enter msg you want to pass to server,type exit stands for disconnet");
            String input =scanner.next();
            if(input.toUpperCase().equals("EXIT")) {
                ctx.writeAndFlush(Signal.disconnect_client_signal);
            } else {
                ByteBuf send = Unpooled.copiedBuffer(input,CharsetUtil.UTF_8);
                ctx.writeAndFlush(send);
            }
        }

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel disconnect successfully now");
    }
}

