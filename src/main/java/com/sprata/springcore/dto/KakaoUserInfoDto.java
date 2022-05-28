package com.sprata.springcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor 생성자를 대신 생성해줌
@Getter
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private  String email;

    public KakaoUserInfoDto(Long id, String nickname, String email) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }
}
