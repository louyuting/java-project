package com.example.netty.cookbook.simplechat;

import com.example.utils.LogUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by louyuting on 16/12/8.
 * 启动服务端
 */
public class SimpleChatServer{
    private int port;

    public SimpleChatServer(int port){
        this.port = port;
    }

    public void run() throws Exception{
        // NioEventLoopGroup是用来处理IO操作的多线程事件循环器
        // boss用来接收进来的连接，
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 用来处理已经被接收的连接;默认是电脑CPU数*2
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            // 是一个启动NIO服务的辅助启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // These EventLoopGroup's are used to handle all the events and IO for ServerChannel and Channel's.
            // 为bootstrap设置acceptor的EventLoopGroup和client的EventLoopGroup
            // 这些EventLoopGroups用于处理所有的IO事件
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new SimpleChatServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128) //boss:初始化服务端可连接队列的大小
                    .childOption(ChannelOption.SO_KEEPALIVE, true); //worker:当设置该选项以后，如果在两小时内没有数据的通信时，TCP会自动发送一个活动探测数据报文。

            LogUtil.log_debug("SimpleChatServer 准备启动了");

            //绑定端口,开始接收进来的连接, 同步等待连接
            ChannelFuture future = serverBootstrap.bind(port).sync();
            LogUtil.log_debug("SimpleChatServer 启动成功了");
            //等待服务器socket关闭
            //在本例子中不会发生,这时可以关闭服务器了
            future.channel().closeFuture().sync();
            LogUtil.log_debug("SimpleChatServer 关闭成功了");
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new SimpleChatServer(8080).run();
    }

}
