//package com.sparta.deliveryproject.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@Table(name ="users")
//public class User {
//
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long userID;
//    @Column
//    private String username;
//    @Column
//    private String password;
//    @Column
//    private String address;
//
//
//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
//    private UserRoleEnum role;
//
//    public User(String username,String password,String address){
//        this.username = username;
//        this.password = password;
//        this.address = address;
//
//    }
//
//}
