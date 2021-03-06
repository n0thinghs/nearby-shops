package com.unitedremote.shops.Services;

import com.unitedremote.shops.DAO.Entities.Shop;

import java.util.List;

public interface ILikeStateService {

    public void likeShop(Long userId, Long shopId);

    public void dislikeShop(Long userId, Long shopId);

    public List<Shop> getLikedShops(Long userId);

    public List<Shop> getDislikedShops(Long userId);

    List<Shop> getNotLikedShops(Long userId);

    Long getLikesCount(Long shopId);

    Long getDislikesCount(Long shopId);

    void removeLikeShop(Long userId, Long shopId);

}
