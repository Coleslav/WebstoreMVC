package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCartRepository implements CartRepository {
    private Map<String,Cart> listOfCarts;

    public InMemoryCartRepository(){
        listOfCarts = new HashMap<String,Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Nie można utworzyć koszyka. Koszyk o wskazanym id juz istnieje."));
        }
        listOfCarts.put(cart.getCartId(),cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException("Nie można zaktualizować koszyka. Koszyk nie istnieje");
        }
        listOfCarts.put(cartId,cart);
    }

    @Override
    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException("Nie można usunąć koszyka. Koszyk nie istnieje");
        }
        listOfCarts.remove(cartId);
    }
}
