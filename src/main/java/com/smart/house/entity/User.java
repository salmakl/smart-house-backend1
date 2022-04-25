package com.smart.house.entity;

import com.smart.house.enums.ERole;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Document("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Id
    private String id;
    private String email;
    private String username;
    private String password;
    @DBRef
    private Set<ERole> roles = new HashSet<>();


}
