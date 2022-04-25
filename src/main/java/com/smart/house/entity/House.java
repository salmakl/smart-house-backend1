package com.smart.house.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("houses")
public class House {
    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String address;

    @DBRef(lazy = true)
    private List<Floor> floors;

    @DBRef(lazy = true)
    private User owner;

}
