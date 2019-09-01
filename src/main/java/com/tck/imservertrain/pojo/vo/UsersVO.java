package com.tck.imservertrain.pojo.vo;


import lombok.Data;


@Data
public class UsersVO {
    private String id;
    private String username;
    private String faceImage;
    private String faceImageBig;
    private String nickname;
    private String qrcode;

}