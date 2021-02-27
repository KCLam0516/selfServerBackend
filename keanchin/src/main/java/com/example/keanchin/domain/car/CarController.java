package com.example.keanchin.domain.car;

import com.example.keanchin.domain.car.object.req.AddCarReq;
import com.example.keanchin.domain.car.object.req.UpdateCarReq;
import com.example.keanchin.domain.car.object.resp.CarReqResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ApiOperation(value = "Add Car")
    @PostMapping("/add")
    public CarReqResp add(
            @RequestBody AddCarReq carReq
    )throws Exception{
        return carService.addCar(carReq);
    }

    @ApiOperation(value = "Remove Car")
    @DeleteMapping("/remove")
    public String delete(
            @RequestParam Long carId
    )throws Exception{
        carService.deleteCar(carId);
        return "Delete Successfully";
    }

    @ApiOperation(value = "Update Car")
    @PutMapping("/Update")
    public CarReqResp update(
            @RequestBody UpdateCarReq carReq
    )throws Exception{
        return carService.updateCar(carReq);
    }
}
