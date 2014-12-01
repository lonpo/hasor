/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.rsf.runtime.common;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import java.net.InetSocketAddress;
/**
 * 
 * @version : 2014年11月14日
 * @author 赵永春(zyc@hasor.net)
 */
public class NetworkConnection {
    private InetSocketAddress remoteAddress = null;
    private InetSocketAddress localAddress  = null;
    private Channel           socketChanne  = null;
    //
    public NetworkConnection(Channel socketChanne) {
        this.socketChanne = socketChanne;
    }
    private InetSocketAddress remote() {
        if (this.remoteAddress == null)
            this.remoteAddress = (InetSocketAddress) socketChanne.remoteAddress();//remote
        return this.remoteAddress;
    }
    private InetSocketAddress local() {
        if (this.localAddress == null)
            this.localAddress = (InetSocketAddress) socketChanne.remoteAddress();//remote
        return this.localAddress;
    }
    //
    /**远程IP（如果远程使用了代理服务器那么该IP将不可信）。*/
    public String getRemotHost() {
        return remote().getAddress().getHostAddress();
    }
    /**远程端口。*/
    public int getRemotePort() {
        return remote().getPort();
    }
    /**本地IP。*/
    public String getLocalHost() {
        return local().getAddress().getHostAddress();
    }
    /**本地端口。*/
    public int getLocalPort() {
        return local().getPort();
    }
    /**连接是否为活动的。*/
    public boolean isActive() {
        return this.socketChanne.isActive();
    }
    /**关闭连接。*/
    public Future<Void> close() {
        return this.socketChanne.close();
    }
    /**获取具体的连接。*/
    public Channel getChannel() {
        return this.socketChanne;
    }
    //
    public static final AttributeKey<NetworkConnection> NettyKey = new AttributeKey<NetworkConnection>("NetworkConnection");
    public static NetworkConnection getConnection(Channel channel) {
        return channel.attr(NettyKey).get();
    }
    public static void initConnection(Channel channel) {
        channel.attr(NettyKey).set(new NetworkConnection(channel));
    }
}