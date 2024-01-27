package com.example.amazonclone.services.ShoppingCart;

import com.example.amazonclone.models.ShoppingCard.CartItem;
import com.example.amazonclone.models.ShoppingCard.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService
{
    ShoppingCart createShoppingCart();

    Optional<ShoppingCart> getShoppingCartById(Long cartId);

    void deleteShoppingCart(Long cartId);

    CartItem addItemToCart(Long cartId, CartItem cartItem);

    void removeItemFromCart(Long cartId, Long itemId);

}


