package com.example.keanchin.domain.user.object;

import com.example.keanchin.dataModel.User;
import com.example.keanchin.dataModel.constant.GenderEnum;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Optional;

@Builder
@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String profileName;
    private Integer age;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private GenderEnum genderType;
    private boolean isActive;

    public static UserDto mapUserDtoFromUser(User user){
        return Optional.ofNullable(user)
                .map(userMap->UserDto.builder()
                        .id(userMap.getId())
                        .username(userMap.getUsername())
                        .profileName(userMap.getProfileName())
                        .age(userMap.getAge())
                        .phoneNumber(userMap.getPhoneNumber())
                        .genderType(userMap.getGenderType())
                        .isActive(userMap.isActive())
                        .build())
                .orElse(null);
    }
}
