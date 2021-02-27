package com.example.keanchin.domain.user;

import com.example.keanchin.dataModel.User;
import com.example.keanchin.dataModel.repository.UserRepo;
import com.example.keanchin.domain.Validator;
import com.example.keanchin.domain.user.object.UserDto;
import com.example.keanchin.domain.user.object.req.AddUserReq;
import com.example.keanchin.domain.user.object.req.LoginReq;
import com.example.keanchin.domain.user.object.req.UpdatePasswordReq;
import com.example.keanchin.domain.user.object.resp.UserReqResp;
import com.example.keanchin.exception.CarRentalErrorCode;
import com.example.keanchin.exception.CarRentalException;
import org.springframework.stereotype.Service;


@Service
public class UserService extends Validator {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserReqResp registerUser(AddUserReq userReq) throws Exception{
        if (!Validator.isValidEmail(userReq.getUsername())) {
            throw new CarRentalException(CarRentalErrorCode.INVALID_USERNAME);
        }
        if(userReq.getPassword()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_PASSWORD);
        }
        User userFound=userRepo.findByUsername(userReq.getUsername());
        if(userFound!=null){
            throw new CarRentalException(CarRentalErrorCode.DUPLICATE_USERNAME);
        }
        if (userReq.getAge()==null || userReq.getAge()<=0) {
            throw new CarRentalException(CarRentalErrorCode.INVALID_AGE);
        }
        if (!Validator.isValidContactNumber(userReq.getPhoneNumber())) {
            throw new CarRentalException(CarRentalErrorCode.INVALID_PHONE);
        }
        String hashPassword = hashPassword(userReq.getPassword());
        User user = User.builder()
                .username(userReq.getUsername())
                .password(hashPassword)
                .profileName(userReq.getProfileName())
                .age(userReq.getAge())
                .phoneNumber(userReq.getPhoneNumber())
                .genderType(userReq.getGenderType())
                .isActive(false)
                .build();

        userRepo.save(user);

        return UserReqResp.builder()
                .userDetails(UserDto.mapUserDtoFromUser(user))
                .build();
    }

    public UserReqResp loginUser(LoginReq loginReq) throws Exception{
        if(loginReq.getUsername()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_USERNAME);
        }
        if(loginReq.getPassword()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_PASSWORD);
        }
        String hashPassword = hashPassword(loginReq.getPassword());
        User userMatch=userRepo.findByUsernameAndPassword(loginReq.getUsername(),hashPassword);
        if(userMatch==null){
            throw new CarRentalException(CarRentalErrorCode.INVALID_LOGIN);
        }
        User user = userMatch.toBuilder()
                .isActive(true)
                .build();

        userRepo.save(user);
        return UserReqResp.builder()
                .userDetails(UserDto.mapUserDtoFromUser(user))
                .build();
    }

    public UserDto logoutUser(Long userId) throws Exception {
        User user=userRepo.findById(userId);
        if(user==null){
            throw new CarRentalException(CarRentalErrorCode.UNEXPECTED_ERROR);
        }
        User userLogout=user.toBuilder()
                .isActive(false)
                .build();

        userRepo.save(userLogout);
        return UserDto.mapUserDtoFromUser(userLogout);
    }

    public UserReqResp updatePassword(UpdatePasswordReq updatePasswordReq) throws Exception{
        if(updatePasswordReq.getUsername()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_USERNAME);
        }
        if(updatePasswordReq.getOldPassword()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_PASSWORD);
        }
        String hashOldPassword = hashPassword(updatePasswordReq.getOldPassword());
        User userMatch=userRepo.findByUsernameAndPassword(updatePasswordReq.getUsername(), hashOldPassword);
        if(userMatch==null){
            throw new CarRentalException(CarRentalErrorCode.INVALID_OLD_PASSWORD);
        }
        if(updatePasswordReq.getNewPassword()==null || updatePasswordReq.getNewPassword().equals(updatePasswordReq.getOldPassword())){
            throw new CarRentalException(CarRentalErrorCode.INVALID_NEW_PASSWORD);
        }
        String hashNewPassword = hashPassword(updatePasswordReq.getNewPassword());
        User updatedUser=userMatch.toBuilder()
                .password(hashNewPassword)
                .build();

        userRepo.save(updatedUser);
        return UserReqResp.builder()
                .userDetails(UserDto.mapUserDtoFromUser(updatedUser))
                .build();
    }
}
