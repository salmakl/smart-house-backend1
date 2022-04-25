package com.smart.house.service;

import com.smart.house.entity.Room;
import com.smart.house.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;


    public List<Room> getAll() {
        try {
            log.info("get all rooms");
            return roomRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all rooms {}", e.getMessage());
            return null;
        }
    }


    public Room create(Room room) {
        try {
            log.info("create room");
            return roomRepository.save(room);
        } catch (Exception e) {
            log.error("error creating room {}", e.getMessage());
            return null;
        }
    }


    public Room getOne(String id) {
        try {
            log.info("get room by id");
            return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        } catch (Exception e) {
            log.error("error getting room by id {}", e.getMessage());
            return null;
        }
    }


    public Room update(Room room) {
        try {
            log.info("update room");
            return roomRepository.save(room);
        } catch (Exception e) {
            log.error("error updating room {}", e.getMessage());
            return null;
        }
    }


    public String delete(String id) {
        try {
            log.info("delete room");
            roomRepository.deleteById(id);
            return "Room deleted";
        } catch (Exception e) {
            log.error("error deleting room {}", e.getMessage());
            return null;
        }
    }
}
