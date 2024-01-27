package com.example.amazonclone.controllers.shoppingCart;

import com.example.amazonclone.models.ShoppingCard.CartItem;
import com.example.amazonclone.models.ShoppingCard.ShoppingCart;
import com.example.amazonclone.services.ShoppingCart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController
{
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping
    public ResponseEntity<ShoppingCart> createShppingCard()
    {
        ShoppingCart newCard = shoppingCartService.createShoppingCart();
        return new ResponseEntity<>(newCard,HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long cartId) {
        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCartById(cartId);
        return cart.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> deleteShoppingCart(@PathVariable Long cartId) {
        shoppingCartService.deleteShoppingCart(cartId);
        return new ResponseEntity<>("Shopping cart deleted successfully", HttpStatus.NO_CONTENT);
    }


    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItem> addItemToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        CartItem addedItem = shoppingCartService.addItemToCart(cartId, cartItem);
        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
    }


    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        shoppingCartService.removeItemFromCart(cartId, itemId);
        return new ResponseEntity<>("Item removed from the cart successfully", HttpStatus.NO_CONTENT);
    }


}
