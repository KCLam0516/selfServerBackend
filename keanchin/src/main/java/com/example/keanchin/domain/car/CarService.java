package com.example.keanchin.domain.car;

import com.example.keanchin.dataModel.Car;
import com.example.keanchin.dataModel.User;
import com.example.keanchin.dataModel.repository.CarRepo;
import com.example.keanchin.dataModel.repository.UserRepo;
import com.example.keanchin.domain.car.object.CarDto;
import com.example.keanchin.domain.car.object.req.AddCarReq;
import com.example.keanchin.domain.car.object.req.UpdateCarReq;
import com.example.keanchin.domain.car.object.resp.CarReqResp;
import com.example.keanchin.exception.CarRentalErrorCode;
import com.example.keanchin.exception.CarRentalException;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepo carRepo;
    private final UserRepo userRepo;

    public CarService(CarRepo carRepo, UserRepo userRepo) {
        this.carRepo = carRepo;
        this.userRepo = userRepo;
    }

    public CarReqResp addCar(AddCarReq carReq)throws Exception{
        User user=userRepo.findById(carReq.getOwnerId());
        if(user==null){
            throw new CarRentalException(CarRentalErrorCode.INVALID_ID);
        }
        if(carReq.getCarName()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_FIELD);
        }
        if(carReq.getDescription()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_FIELD);
        }
        if(carReq.getDailyCarRating()==null || carReq.getDailyCarRating()<=0){
            throw new CarRentalException(CarRentalErrorCode.INVALID_VALUE_INPUT);
        }
        Car car = Car.builder()
                .carName(carReq.getCarName())
                .description(carReq.getDescription())
                .dailyCarRating(carReq.getDailyCarRating())
                .user(user)
                .isDeleted(false)
                .isBooked(false)
                .build();

        carRepo.save(car);

        return CarReqResp.builder()
                .carDetails(CarDto.mapCarDtoFromCar(car))
                .build();
    }

    public void deleteCar(Long carId)throws Exception{
        if(carId==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_FIELD);
        }
        Car car= carRepo.findById(carId);
        if(car==null){
            throw new CarRentalException(CarRentalErrorCode.UNEXPECTED_ERROR);
        }
        Car deletedCar = car.toBuilder().isDeleted(true).build();
        carRepo.save(deletedCar);
    }

    public CarReqResp updateCar(UpdateCarReq carReq)throws Exception{
        Car car= carRepo.findById(carReq.getId());
        if(car==null){
            throw new CarRentalException(CarRentalErrorCode.INVALID_ID);
        }
        if(carReq.getCarName()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_FIELD);
        }
        if(carReq.getDescription()==null){
            throw new CarRentalException(CarRentalErrorCode.EMPTY_FIELD);
        }
        if(carReq.getDailyCarRating()==null || carReq.getDailyCarRating()<=0){
            throw new CarRentalException(CarRentalErrorCode.INVALID_VALUE_INPUT);
        }
        Car updatedCar = car.toBuilder()
                .carName(carReq.getCarName())
                .description(carReq.getDescription())
                .dailyCarRating(carReq.getDailyCarRating())
                .build();

        carRepo.save(updatedCar);

        return CarReqResp.builder()
                .carDetails(CarDto.mapCarDtoFromCar(car))
                .build();
    }
}
