package com.example.keanchin.domain.user.object.req;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginReq {
    private String username;
    private String password;
}
