package com.rogasree.rogasreemart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemRepository
        extends JpaRepository<WishlistItem, Long> {

    List<WishlistItem> findByUserId(Long userId);
}