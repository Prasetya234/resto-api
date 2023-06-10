package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.dto.AddcartreqDTO;
import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Cart;
import com.belajarspringboot.resto.model.CartItem;
import com.belajarspringboot.resto.model.Product;
import com.belajarspringboot.resto.model.User;
import com.belajarspringboot.resto.respository.CartItemRespository;
import com.belajarspringboot.resto.respository.CartRespository;
import com.belajarspringboot.resto.respository.ProductRespository;
import com.belajarspringboot.resto.respository.UserRespository;
import com.belajarspringboot.resto.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRespository cartRespository;

    @Autowired
    private CartItemRespository cartItemRespository;

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private ProductRespository productRespository;
    private static float totalBayar;
    @Override
    public Cart tambah(AddcartreqDTO addcartreqDTO){
        totalBayar = 0;

        User finduser = userRespository.findById(addcartreqDTO.getNo_user()).orElseThrow(() -> new NotFoundException("User id tidak ditemukan"));
        var cartExist = cartRespository.findByUserAndStatusIsFalse(finduser);
        Cart dataCart;

        if (cartExist.isPresent()){
            dataCart = cartExist.get();
        }else{
            Cart cart = new Cart();
            cart.setUser(finduser);
            dataCart = cartRespository.save(cart);
        }

        CartItem cartItem = new CartItem();
        cartItem.setQty(addcartreqDTO.getQty());
        Product findProduct = productRespository.findById(addcartreqDTO.getNo_product()).orElseThrow(()-> new NotFoundException("Product id tidak ditemukan"));
        cartItem.setProduct(findProduct);
        cartItem.setTotal(cartItem.getProduct().getHarga() * cartItem.getQty());
        dataCart.addCartItem(cartItem);
        cartItemRespository.save(cartItem);

        dataCart.getCartItems().stream().forEach(v -> totalBayar += v.getTotal());
        dataCart.setBayar(totalBayar);
        return cartRespository.save(dataCart);

    }
    @Override
    public Cart removeCartItem(int noCart, int noCartItem) {
        Cart cart = cartRespository.findById(noCart).orElseThrow(() -> new NotFoundException("Cart ga di temukan"));
        cart.removeCartItem(noCartItem);
        return cartRespository.save(cart);
    }
    @Override
    public List<Cart> findAllByUserId(int userNo){
        User user = userRespository.findById(userNo).orElseThrow(() -> new NotFoundException("User id tidak ditemukan"));
        return cartRespository.findAllByUser(user);
    }
}
