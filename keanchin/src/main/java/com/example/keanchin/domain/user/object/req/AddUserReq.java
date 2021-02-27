package com.example.keanchin.domain.user.object.req;

import com.example.keanchin.dataModel.constant.GenderEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddUserReq {
    private String username;
    private String password;
    private String profileName;
    private Integer age;
    private String phoneNumber;
    private GenderEnum genderType;
}
