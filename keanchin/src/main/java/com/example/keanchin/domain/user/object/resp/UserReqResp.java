package com.example.keanchin.domain.user.object.resp;

import com.example.keanchin.domain.user.object.UserDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserReqResp {
    private UserDto userDetails;
}
