package com.unitedremote.shops.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    Long id;
    String name;
    @Embedded
    Location location;
    @OneToMany(mappedBy = "shop")
    List<LikeStateShop> likes;

}
