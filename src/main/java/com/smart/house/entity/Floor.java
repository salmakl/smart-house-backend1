package com.smart.house.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("floors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Floor {
    @Id
    private String id;

    private String number;

    @DBRef(lazy = true)
    private List<Room> rooms;

    @DBRef(lazy = true)
    private House house;

}
