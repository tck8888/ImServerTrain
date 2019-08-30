package com.tck.imservertrain.netty;

import io.netty.channel.Channel;

import java.util.HashMap;

/**
 * description:</br>
 * created on: 2019/8/30 8:28</br>
 *
 * @author tck
 * @version 1.0
 */
public class UserChannelRel {

    private static HashMap<String, Channel> manager = new HashMap<>();

    public static void put(String senderId,Channel channel){
        manager.put(senderId,channel);
    }

    public static Channel get(String senderId){
        return manager.get(senderId);
    }


    public static void output() {
        for (HashMap.Entry<String, Channel> entry : manager.entrySet()) {
            System.out.println("UserId: " + entry.getKey()
                    + ", ChannelId: " + entry.getValue().id().asLongText());
        }
    }
}
