package com.example.amazonclone.Repository;

import com.example.amazonclone.models.ShoppingCard.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long>
{

}
