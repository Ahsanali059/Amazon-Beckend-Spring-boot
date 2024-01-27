package com.example.amazonclone.services.ShoppingCart;

import com.example.amazonclone.Repository.CartItemRepository;
import com.example.amazonclone.Repository.ShoppingCartRepository;
import com.example.amazonclone.models.ShoppingCard.CartItem;
import com.example.amazonclone.models.ShoppingCard.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public ShoppingCart createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> getShoppingCartById(Long cartId) {
        return shoppingCartRepository.findById(cartId);
    }

    @Override
    public void deleteShoppingCart(Long cartId) {
        shoppingCartRepository.deleteById(cartId);
    }

    @Override
    public CartItem addItemToCart(Long cartId, CartItem cartItem) {
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);

        if (optionalShoppingCart.isPresent()) {
            ShoppingCart shoppingCart = optionalShoppingCart.get();

            // Associate the cart item with the shopping cart
            cartItem.setShoppingCart(shoppingCart);

            // Save the cart item
            return cartItemRepository.save(cartItem);
        } else {
            throw new RuntimeException("Shopping cart not found");
        }


    }

    @Override
    public void removeItemFromCart(Long cartId, Long itemId) {
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);

        if (optionalShoppingCart.isPresent()) {
            ShoppingCart shoppingCart = optionalShoppingCart.get();

            // Check if the cart item exists in the shopping cart
            Optional<CartItem> optionalCartItem = cartItemRepository.findById(itemId);
            if (optionalCartItem.isPresent()) {
                CartItem cartItem = optionalCartItem.get();

                // Ensure that the cart item belongs to the specified shopping cart
                if (cartItem.getShoppingCart().equals(shoppingCart)) {
                    // Remove the cart item from the shopping cart
                    shoppingCart.getCartItems().remove(cartItem);

                    // Disassociate the cart item from the shopping cart
                    cartItem.setShoppingCart(null);

                    // Delete the cart item
                    cartItemRepository.delete(cartItem);
                } else {
                    throw new RuntimeException("Cart item does not belong to the specified shopping cart");
                }
            } else {
                throw new RuntimeException("Cart item not found");
            }
        } else {
            throw new RuntimeException("Shopping cart not found");
        }
    }
}