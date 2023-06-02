package io.unifycom.netty.channel.bluetooth;

import io.netty.channel.ChannelConfig;

interface BluetoothChannelConfig extends ChannelConfig {

    String getAddress();

    public void setAddress(String address);

    int getChannel();

    void setChannel(int channel);

    boolean isAuthenticate();

    void setAuthenticate(boolean authenticate);

    boolean isEncrypt();

    void setEncrypt(boolean encrypt);

    boolean isMaster();

    void setMaster(boolean master);
}
