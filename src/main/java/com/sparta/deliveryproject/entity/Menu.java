package com.sparta.deliveryproject.entity;

import com.sparta.deliveryproject.dto.MenuRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menu")
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String introduce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public Menu(Store store, MenuRequestDto menuRequestDto, int priceInt) {
        this.store = store;
        this.name = menuRequestDto.getName();
        this.price = priceInt;
        this.introduce = menuRequestDto.getIntroduce();
    }

    public void update(MenuRequestDto menuRequestDto, int priceInt) {
        this.name = menuRequestDto.getName();
        this.price = priceInt;
        this.introduce = menuRequestDto.getIntroduce();
    }
}
