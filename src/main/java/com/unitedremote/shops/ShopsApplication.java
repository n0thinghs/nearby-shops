package com.unitedremote.shops;

import com.unitedremote.shops.DAO.Entities.Location;
import com.unitedremote.shops.DAO.Entities.Shop;
import com.unitedremote.shops.DAO.Entities.User;
import com.unitedremote.shops.DAO.Repositories.LikeStateShopRepository;
import com.unitedremote.shops.DAO.Repositories.ShopRepository;
import com.unitedremote.shops.DAO.Repositories.UserRepository;
import com.unitedremote.shops.Services.IShopService;
import com.unitedremote.shops.Services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class ShopsApplication {

    Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(ShopsApplication.class, args);
    }

    @Bean
    public CommandLineRunner initApp(UserRepository userRepository, ShopRepository shopRepository, LikeStateShopRepository likeStateShopRepository,
                                     IShopService shopService, UserServiceImpl userService) {
        return args -> {
            Stream.of("Mohamed", "Nihal", "Otmane", "Moustafa")
                    .forEach(userName -> userRepository.save(User.builder()
                            .name(userName)
                            .email(userName + "@gmail.com")
                            .roles(Arrays.asList("USER"))
                            .password(passwordEncoder().encode(userName))
                            .location(new Location(random.nextInt(100) + Math.random(), random.nextInt(100) + Math.random()))
                            .build()
                    ));

            Stream.of("Marjane", "IKEA", "Carfourre", "Acima", "Aswak Essalam", "Walmart")
                    .forEach(shopName -> shopRepository.save(Shop.builder()
                            .name(shopName)
                            .location(new Location(random.nextInt(100) + Math.random(), random.nextInt(100) + Math.random()))
                            .build()));

            userRepository.findAll().forEach(System.out::println);
            shopRepository.findAll().forEach(System.out::println);

//            userService.likeShop(1L, 5L);
//            userService.likeShop(2L, 5L);
//            userService.likeShop(3L, 5L);
//            userService.likeShop(1L, 6L);
//            userService.dislikeShop(1L, 7L);
//            userService.likeShop(2L, 5L);
//
//            System.out.println(shopService.getLikesCount(5L));
//            System.out.println(shopService.getLikesCount(6L));
//            System.out.println(shopService.getLikesCount(7L));
//            System.out.println(shopService.getDislikesCount(7L));
//
//            System.out.println(shopRepository.findByNameContainingIgnoreCase("M"));



        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

