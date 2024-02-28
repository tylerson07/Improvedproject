package com.sparta.deliveryproject.dto;

import com.sparta.deliveryproject.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private String username;
    private String address;
    private String auth;

    public UserResponseDto(User user){
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.auth = user.getAuthorities().toString();
    }
}
