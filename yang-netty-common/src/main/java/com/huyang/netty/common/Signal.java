package com.huyang.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class Signal {
    public static final ByteBuf disconnect_server_signal = Unpooled.copiedBuffer("SERVER_ASK_DISCONNECT", CharsetUtil.UTF_8);

    public static final ByteBuf disconnect_client_signal = Unpooled.copiedBuffer("CLIENT_ASK_DISCONNECT",CharsetUtil.UTF_8);
}
