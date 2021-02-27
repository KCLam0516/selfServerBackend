package com.example.keanchin.domain.user.object.req;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdatePasswordReq {
    private String username;
    private String oldPassword;
    private String newPassword;
}
