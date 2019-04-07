package com.huyang.netty.server.diy;

import com.huyang.netty.common.Signal;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class DIyServerInboundHandler extends ChannelInboundHandlerAdapter {



    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active now!");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
        ByteBuf received = (ByteBuf) msg;
        ByteBuf response;
        System.out.println("server received :"+received.toString(CharsetUtil.UTF_8));
        if(received.equals(Signal.disconnect_client_signal)) {
             response = Signal.disconnect_server_signal;
        } else {
             response = renderResponseByteBuf(received);
        }

        ctx.writeAndFlush(response);
    }

    private ByteBuf renderResponseByteBuf(ByteBuf byteBuf) {
        String response = "rendered by server["+byteBuf.toString(CharsetUtil.UTF_8)+"]";
        return Unpooled.copiedBuffer(response,CharsetUtil.UTF_8);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
       super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel inactive now");
    }
}
