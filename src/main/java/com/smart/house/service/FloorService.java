package com.smart.house.service;

import com.smart.house.entity.Floor;
import com.smart.house.entity.House;
import com.smart.house.repository.FloorRepository;
import com.smart.house.repository.HouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> findAll() {
        return floorRepository.findAll();
    }

    public Floor addFloor(Floor floor) {
        return floorRepository.save(floor);
    }



    public void deleteFloor(String id) {

    }
}
