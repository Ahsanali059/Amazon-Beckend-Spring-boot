package com.example.amazonclone.Repository;

import com.example.amazonclone.models.ShoppingCard.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long>
{
    // We can add custom query methods here if needed
}
