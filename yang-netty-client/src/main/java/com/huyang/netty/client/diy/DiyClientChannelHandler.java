package com.huyang.netty.client.diy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

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
        System.out.println("client received :"+received.toString(CharsetUtil.UTF_8));
//        ByteBuf response = (ByteBuf) Unpooled.copiedBuffer("diyclient enriched:"+received.toString(CharsetUtil.UTF_8), Charset.defaultCharset());
//        ctx.writeAndFlush(response);
    }
}

