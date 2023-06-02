package io.unifycom.netty.channel.bluetooth.netty;

import io.unifycom.netty.channel.bluetooth.BluetoothDeviceAddress;
import io.unifycom.netty.channel.bluetooth.OioBluetoothChannel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.junit.Test;

public class OioBluetoothChannelTest {

    @Test
    public void testConnect() {

        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup workerGroup = new OioEventLoopGroup();


        bootstrap.group(workerGroup).channel(OioBluetoothChannel.class).remoteAddress(new BluetoothDeviceAddress("btspp://000878439229:1;authenticate=false;encrypt=false;master=false"))
                .handler(new ChannelInitializer<OioBluetoothChannel>() {

                    @Override
                    public void initChannel(OioBluetoothChannel ch) {
                        ch.pipeline().addLast(new StringDecoder()).addLast(new StringEncoder());
                    }
                });

        bootstrap.connect().syncUninterruptibly();
    }
}
